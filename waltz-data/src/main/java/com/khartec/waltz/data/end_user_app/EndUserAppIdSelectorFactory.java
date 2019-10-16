/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.data.end_user_app;

import com.khartec.waltz.data.orgunit.OrganisationalUnitIdSelectorFactory;
import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.EntityReference;
import com.khartec.waltz.model.IdSelectionOptions;
import com.khartec.waltz.model.application.ApplicationKind;
import com.khartec.waltz.schema.tables.EndUserApplication;
import com.khartec.waltz.schema.tables.Involvement;
import com.khartec.waltz.schema.tables.Person;
import com.khartec.waltz.schema.tables.PersonHierarchy;
import org.jooq.Condition;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

import static com.khartec.waltz.common.Checks.checkNotNull;
import static com.khartec.waltz.schema.tables.EndUserApplication.END_USER_APPLICATION;
import static com.khartec.waltz.schema.tables.Involvement.INVOLVEMENT;
import static com.khartec.waltz.schema.tables.Person.PERSON;
import static com.khartec.waltz.schema.tables.PersonHierarchy.PERSON_HIERARCHY;

public class EndUserAppIdSelectorFactory implements Function<IdSelectionOptions, Select<Record1<Long>>>  {

    private static final Logger LOG = LoggerFactory.getLogger(EndUserAppIdSelectorFactory.class);

    private final EndUserApplication eua = END_USER_APPLICATION.as("eua");
    private final Involvement involvement = INVOLVEMENT.as("involvement");
    private final OrganisationalUnitIdSelectorFactory orgUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    private final Person person = PERSON.as("per");
    private final PersonHierarchy personHierarchy = PERSON_HIERARCHY.as("phier");



    @Override
    public Select<Record1<Long>> apply(IdSelectionOptions options) {
        checkNotNull(options, "options cannot be null");
        EntityReference ref = options.entityReference();
        switch (ref.kind()) {
            case ORG_UNIT:
                return mkForOrgUnit(options);
            case PERSON:
                return mkForPerson(options);
            default:
                throw new IllegalArgumentException("Cannot create selector for entity kind: " + ref.kind());
        }
    }


    private Select<Record1<Long>> mkForOrgUnit(IdSelectionOptions options) {

        if (eucOmitted(options)) {
            return mkEmptySelect();
        }

        Select<Record1<Long>> ouSelector = orgUnitIdSelectorFactory.apply(options);

        return DSL
                .selectDistinct(eua.ID)
                .from(eua)
                .where(eua.ORGANISATIONAL_UNIT_ID.in(ouSelector));
    }


    private Select<Record1<Long>> mkForPerson(IdSelectionOptions options) {
        switch (options.scope()) {
            case EXACT:
                return mkForSinglePerson(options);
            case CHILDREN:
                return mkForPersonReportees(options);
            default:
                throw new UnsupportedOperationException(
                        "Querying for appIds of person using (scope: '"
                                + options.scope()
                                + "') not supported");
        }
    }


    private Select<Record1<Long>> mkForSinglePerson(IdSelectionOptions options) {

        if (eucOmitted(options)) {
            return mkEmptySelect();
        }

        Select<Record1<String>> employeeId = mkEmployeeIdSelect(options.entityReference());

        return DSL
                .selectDistinct(involvement.ENTITY_ID)
                .from(involvement)
                .innerJoin(eua)
                .on(eua.ID.eq(involvement.ENTITY_ID))
                .where(involvement.ENTITY_KIND.eq(EntityKind.END_USER_APPLICATION.name()))
                .and(involvement.EMPLOYEE_ID.eq(employeeId));
    }


    private Select<Record1<Long>> mkForPersonReportees(IdSelectionOptions options) {

        if (eucOmitted(options)) {
            return mkEmptySelect();
        }

        Select<Record1<String>> employeeId = mkEmployeeIdSelect(options.entityReference());
        SelectConditionStep<Record1<String>> reporteeIds = DSL.selectDistinct(personHierarchy.EMPLOYEE_ID)
                .from(personHierarchy)
                .where(personHierarchy.MANAGER_ID.eq(employeeId));

        Condition condition = involvement.ENTITY_KIND.eq(EntityKind.END_USER_APPLICATION.name())
                .and(involvement.EMPLOYEE_ID.eq(employeeId)
                        .or(involvement.EMPLOYEE_ID.in(reporteeIds)));

        return DSL
                .selectDistinct(involvement.ENTITY_ID)
                .from(involvement)
                .innerJoin(eua)
                .on(eua.ID.eq(involvement.ENTITY_ID))
                .where(condition);
    }


    private boolean eucOmitted(IdSelectionOptions options) {
        return options.filters().omitApplicationKinds().contains(ApplicationKind.EUC);
    }


    private Select<Record1<String>> mkEmployeeIdSelect(EntityReference ref) {
        return DSL
                .select(person.EMPLOYEE_ID)
                .from(person)
                .where(person.ID.eq(ref.id()));
    }


    private Select<Record1<Long>> mkEmptySelect() {
        return DSL
                .select(eua.ID)
                .from(eua)
                .where(DSL.falseCondition());
    }

}
