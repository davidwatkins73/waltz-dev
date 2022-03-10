/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific
 *
 */

package org.finos.waltz.service.attestation;

import org.finos.waltz.common.exception.UpdateFailedException;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.GenericSelectorFactory;
import org.finos.waltz.data.application.ApplicationIdSelectorFactory;
import org.finos.waltz.data.attestation.AttestationInstanceDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.*;
import org.finos.waltz.model.attestation.*;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.permission_group.ImmutableCheckPermissionCommand;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.jooq.Condition;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;
import static org.finos.waltz.common.Checks.*;
import static org.finos.waltz.common.CollectionUtilities.first;
import static org.finos.waltz.common.CollectionUtilities.notEmpty;
import static org.finos.waltz.common.DateTimeUtilities.*;
import static org.finos.waltz.common.StringUtilities.join;
import static org.finos.waltz.schema.Tables.APPLICATION;


@Service
public class AttestationInstanceService {

    private static final Logger LOG = LoggerFactory.getLogger(AttestationInstanceService.class);

    private final AttestationInstanceDao attestationInstanceDao;
    private final AttestationRunService attestationRunService;
    private final AttestationPreCheckService attestationPreCheckService;
    private final ApplicationService applicationService;
    private final PersonDao personDao;
    private final ChangeLogService changeLogService;
    private final PermissionGroupService permissionGroupService;

    private final GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();


    public AttestationInstanceService(AttestationInstanceDao attestationInstanceDao,
                                      AttestationRunService attestationRunService,
                                      AttestationPreCheckService attestationPreCheckService,
                                      ApplicationService applicationService,
                                      PersonDao personDao, ChangeLogService changeLogService,
                                      PermissionGroupService permissionGroupService) {

        checkNotNull(attestationInstanceDao, "attestationInstanceDao cannot be null");
        checkNotNull(attestationRunService, "attestationRunService cannot be null");
        checkNotNull(personDao, "personDao cannot be null");
        checkNotNull(changeLogService, "changeLogService cannot be null");

        this.attestationInstanceDao = attestationInstanceDao;
        this.attestationRunService = attestationRunService;
        this.attestationPreCheckService = attestationPreCheckService;
        this.applicationService = applicationService;
        this.personDao = personDao;
        this.changeLogService = changeLogService;
        this.permissionGroupService = permissionGroupService;
    }


    public List<AttestationInstance> findByRecipient(String userId, boolean unattestedOnly) {
        checkNotNull(userId, "userId cannot be null");

        return attestationInstanceDao.findByRecipient(userId, unattestedOnly);
    }


    public List<AttestationInstance> findHistoricalForPendingByUserId(String userId) {
        checkNotNull(userId, "userId cannot be null");

        return attestationInstanceDao.findHistoricalForPendingByUserId(userId);
    }


    public List<AttestationInstance> findByEntityReference(EntityReference ref) {
        checkNotNull(ref, "ref cannot be null");

        return attestationInstanceDao.findByEntityReference(ref);
    }


    public boolean attestInstance(long instanceId, String attestedBy) {
        checkNotEmpty(attestedBy, "attestedBy must be provided");

        boolean success = attestationInstanceDao.attestInstance(instanceId, attestedBy, nowUtc());
        if (success) {
            AttestationInstance instance = attestationInstanceDao.getById(instanceId);
            AttestationRun run = attestationRunService.getById(instance.attestationRunId());
            logChange(attestedBy, instance, run.attestedEntityKind());
        }
        return success;
    }


    public List<AttestationInstance> findByRunId(long runId) {
        return attestationInstanceDao.findByRunId(runId);
    }


    public List<Person> findPersonsByInstanceId(long id) {
        return personDao.findPersonsByAttestationInstanceId(id);
    }


    public List<AttestationInstance> findByIdSelector(IdSelectionOptions options) {
        Select<Record1<Long>> selector = mkIdSelector(options);
        return attestationInstanceDao.findByIdSelector(selector);
    }


    public int cleanupOrphans() {
        return attestationInstanceDao.cleanupOrphans();
    }


    public AttestationSyncRecipientsResponse reassignRecipients() {
        return attestationInstanceDao.reassignRecipients();
    }


    public AttestationSyncRecipientsResponse getCountsOfRecipientsToReassign() {
        return attestationInstanceDao.getCountsOfRecipientsToReassign();
    }


    private Select<Record1<Long>> mkIdSelector(IdSelectionOptions selectionOptions) {
        GenericSelector genericSelector = genericSelectorFactory.applyForKind(EntityKind.ATTESTATION, selectionOptions);
        return genericSelector.selector();
    }

    private void logChange(String username, AttestationInstance instance, EntityKind attestedKind) {

        String logMessage = EntityKind.APPLICATION.equals(instance.parentEntity().kind())
                ? format("Attestation of %s for application %s",
                attestedKind,
                ExternalIdValue.orElse(
                        applicationService
                                .getById(instance.parentEntity().id())
                                .assetCode(),
                        "UNKNOWN"))
                : format("Attestation of %s ", attestedKind);

        changeLogService.write(ImmutableChangeLog.builder()
                .message(logMessage)
                .parentReference(instance.parentEntity())
                .userId(username)
                .severity(Severity.INFORMATION)
                .childKind(attestedKind)
                .operation(Operation.ATTEST)
                .build());
    }


    public boolean attestForEntity(String username, AttestEntityCommand createCommand) {
        checkAttestationPermission(username, createCommand);

        if(createCommand.attestedEntityKind().equals(EntityKind.LOGICAL_DATA_FLOW)){
            checkLogicalFlowsCanBeAttested(createCommand);
        }

        List<AttestationInstance> instancesForEntityForUser = attestationInstanceDao
                .findForEntityByRecipient(
                        createCommand,
                        username,
                        true);

        if (notEmpty(instancesForEntityForUser)) {
            instancesForEntityForUser
                    .forEach(attestation -> {
                        try {
                            Long instanceId = getInstanceId(attestation);
                            attestInstance(instanceId, username);
                        } catch (Exception e) {
                            LOG.error("Failed to attest instance", e);
                        }
                    });

            return true;
        } else {
            IdCommandResponse idCommandResponse = attestationRunService.createRunForEntity(username, createCommand);
            Long runId = getRunId(idCommandResponse);

            Long instanceId = getInstanceId(first(findByRunId(runId)));
            return attestInstance(instanceId, username);
        }
    }


    private void checkLogicalFlowsCanBeAttested(AttestEntityCommand createCommand) {
        List<String> failures = attestationPreCheckService.calcLogicalFlowPreCheckFailures(createCommand.entityReference());
        checkEmpty(
                failures,
                () -> format(
                        "Logical flow check failed with the following warnings: %s",
                        join(failures, ";")));
    }


    public Set<LatestMeasurableAttestationInfo> findLatestMeasurableAttestations(EntityReference ref) {
        return attestationInstanceDao.findLatestMeasurableAttestations(ref);
    }


    private void checkAttestationPermission(String username, AttestEntityCommand createCommand) {

        boolean hasAttestationPermission = permissionGroupService.hasPermission(ImmutableCheckPermissionCommand
                .builder()
                .parentEntityRef(createCommand.entityReference())
                .subjectKind(EntityKind.ATTESTATION)
                .qualifierKind(createCommand.attestedEntityKind())
                .qualifierId(createCommand.attestedEntityId())
                .user(username)
                .build());

        if (!hasAttestationPermission) {
            throw new UpdateFailedException("ATTESTATION_FAILED",
                    "user does not have permission to attest " + createCommand.attestedEntityKind().prettyName());
        }
    }

    private Long getRunId(IdCommandResponse idCommandResponse) throws IllegalStateException {
        return idCommandResponse.id()
                .orElseThrow(() -> new IllegalStateException("Unable to get identifier for this run"));
    }

    private Long getInstanceId(AttestationInstance attestation) throws IllegalStateException {
        return attestation
                .id()
                .orElseThrow(() -> new IllegalStateException("Unable to get identifier for this instance"));
    }


    public Set<ApplicationAttestationInstanceSummary> findApplicationAttestationInstancesForKindAndSelector(EntityKind attestedKind,
                                                                                                            Long attestedId,
                                                                                                            ApplicationAttestationInstanceInfo attestationInfo) {

        Condition condition = getApplicationAttestationFilterCondition(attestationInfo.filters());

        ApplicationIdSelectorFactory applicationIdSelectorFactory = new ApplicationIdSelectorFactory();
        Select<Record1<Long>> appIds = applicationIdSelectorFactory.apply(attestationInfo.selectionOptions());

        return attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
                attestedKind,
                attestedId,
                appIds,
                condition);
    }


    public Set<ApplicationAttestationSummaryCounts> findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo applicationAttestationInstanceInfo) {

        Condition condition = getApplicationAttestationFilterCondition(applicationAttestationInstanceInfo.filters());

        ApplicationIdSelectorFactory applicationIdSelectorFactory = new ApplicationIdSelectorFactory();
        Select<Record1<Long>> appIds = applicationIdSelectorFactory.apply(applicationAttestationInstanceInfo.selectionOptions());

        return attestationInstanceDao.findAttestationInstanceSummaryForSelector(appIds, condition);
    }


    private Condition getApplicationAttestationFilterCondition(ApplicationAttestationSummaryFilters filters) {
        Condition criticalityCondition = filters.appCriticality()
                .map(criticality -> APPLICATION.BUSINESS_CRITICALITY.eq(criticality.name()))
                .orElse(DSL.trueCondition());

        Condition lifecyclePhaseCondition = filters.appLifecyclePhase()
                .map(lifecyclePhase -> APPLICATION.LIFECYCLE_PHASE.eq(lifecyclePhase.name()))
                .orElse(DSL.trueCondition());

        Condition attestationStateCondition = filters.attestationState()
                .map(state -> AttestationState.ATTESTED.equals(state)
                        ? DSL.field("attested_at", Timestamp.class).isNotNull()
                        : DSL.field("attested_at", Timestamp.class).isNull())
                .orElse(DSL.trueCondition());

        Condition dateCondition = filters.attestationsFromDate()
                .map(fromDate -> DSL.field("attested_at", Timestamp.class).ge(Timestamp.valueOf(toLocalDateTime(toSqlDate(fromDate)))))
                .orElse(DSL.trueCondition());

        return dateCondition.and(lifecyclePhaseCondition.and(criticalityCondition).and(attestationStateCondition));
    }
}
