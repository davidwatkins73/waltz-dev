package com.khartec.waltz.jobs.tools.importers;

import com.khartec.waltz.common.*;
import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.schema.tables.records.AssessmentRatingRecord;
import com.khartec.waltz.service.DIConfiguration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jooq.DSLContext;
import org.jooq.lambda.tuple.Tuple5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import static com.khartec.waltz.common.StreamUtilities.mkSiphon;
import static com.khartec.waltz.data.JooqUtilities.readRef;
import static com.khartec.waltz.jobs.XlsUtilities.strVal;
import static com.khartec.waltz.jobs.XlsUtilities.streamRows;
import static com.khartec.waltz.jobs.tools.importers.DiffResult.mkDiff;
import static com.khartec.waltz.model.EntityReference.mkRef;
import static com.khartec.waltz.schema.Tables.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.jooq.lambda.tuple.Tuple.tuple;

@Component
public class AssessmentRatingBulkImport {

    private static final Logger LOG = LoggerFactory.getLogger(AssessmentRatingBulkImport.class);
    private static final String PROVENANCE = "waltz_bulk_assessment_rating_importer";
    private final DSLContext dsl;


    @Autowired
    public AssessmentRatingBulkImport(DSLContext dsl) {
        this.dsl = dsl;
    }


    public void load(String filename, AssessmentRatingBulkImportConfig config) throws IOException {

        InputStream inputStream = IOUtilities.getFileResource(filename).getInputStream();

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(config.sheetPosition());

        Set<AssessmentRatingEntry> requiredRatings = loadRequiredRatings(config, sheet);
        Set<AssessmentRatingEntry> existingRatings = loadExistingRatings(config);

        DiffResult<AssessmentRatingEntry> diff = mkDiff(
                existingRatings,
                requiredRatings,
                AssessmentRatingEntry::entity,
                Object::equals);

        dsl.transaction(ctx -> {
            DSLContext tx = ctx.dsl();

            insertNewRecords(tx, config, diff.otherOnly());
            updateExistingRecords(tx, config, diff.differingIntersection());

            if(config.mode().equals(SynchronisationMode.FULL)){
                removeRedundantRecords(tx, config, diff.waltzOnly());
            }

//            throw new  IllegalArgumentException("BBooooooOOOOOooMMMMMMMM!");
        });
    }

    private void removeRedundantRecords(DSLContext tx,
                                        AssessmentRatingBulkImportConfig config,
                                        Collection<AssessmentRatingEntry> toRemove) {
        int[] removedRecords = toRemove
                .stream()
                .map(r -> dsl
                        .deleteFrom(ASSESSMENT_RATING)
                        .where(ASSESSMENT_RATING.ASSESSMENT_DEFINITION_ID.eq(config.assessmentDefinitionId())
                                .and(ASSESSMENT_RATING.ENTITY_ID.eq(r.entity().id())
                                        .and(ASSESSMENT_RATING.ENTITY_KIND.eq(r.entity().kind().name())))))
                .collect(collectingAndThen(toSet(), tx::batch))
                .execute();

        LOG.debug(format("Deleted assessment ratings for %d records", IntStream.of(removedRecords).sum()));
    }


    private void updateExistingRecords(DSLContext tx,
                                       AssessmentRatingBulkImportConfig config,
                                       Collection<AssessmentRatingEntry> toUpdate) {
        int[] updatedRecords = toUpdate
                .stream()
                .map(r -> dsl
                        .update(ASSESSMENT_RATING)
                        .set(ASSESSMENT_RATING.DESCRIPTION, r.description())
                        .set(ASSESSMENT_RATING.RATING_ID, r.ratingId())
                        .set(ASSESSMENT_RATING.LAST_UPDATED_AT, DateTimeUtilities.nowUtcTimestamp())
                        .set(ASSESSMENT_RATING.LAST_UPDATED_BY, config.updateUser())
                        .where(ASSESSMENT_RATING.ASSESSMENT_DEFINITION_ID.eq(config.assessmentDefinitionId())
                                .and(ASSESSMENT_RATING.ENTITY_KIND.eq(r.entity().kind().name())
                                        .and(ASSESSMENT_RATING.ENTITY_ID.eq(r.entity().id())))))
                .collect(collectingAndThen(toSet(), tx::batch))
                .execute();

        LOG.debug(format("Updated ratings or descriptions for %d records", IntStream.of(updatedRecords).sum()));
    }


    private void insertNewRecords(DSLContext tx,
                                  AssessmentRatingBulkImportConfig config,
                                  Collection<AssessmentRatingEntry> newRecords) {
        int[] insertedRecords = newRecords
                .stream()
                .map(r -> mkAssessmentRatingRecord(config.assessmentDefinitionId(), r, config.updateUser()))
                .collect(collectingAndThen(toSet(), tx::batchInsert))
                .execute();

        LOG.debug(format("inserted new assessment ratings for %d records", IntStream.of(insertedRecords).sum()));
    }


    private Set<AssessmentRatingEntry> loadExistingRatings(AssessmentRatingBulkImportConfig config) {
        return dsl
                .select(ASSESSMENT_RATING.ENTITY_ID,
                        ASSESSMENT_RATING.ENTITY_KIND,
                        ASSESSMENT_RATING.RATING_ID,
                        ASSESSMENT_RATING.DESCRIPTION)
                .from(ASSESSMENT_RATING)
                .where(ASSESSMENT_RATING.ASSESSMENT_DEFINITION_ID.eq(config.assessmentDefinitionId()))
                .fetchSet(r -> ImmutableAssessmentRatingEntry.builder()
                        .entity(readRef(r, ASSESSMENT_RATING.ENTITY_KIND, ASSESSMENT_RATING.ENTITY_ID))
                        .ratingId(r.get(ASSESSMENT_RATING.RATING_ID))
                        .description(r.get(ASSESSMENT_RATING.DESCRIPTION))
                        .build());
    }


    private Set<AssessmentRatingEntry> loadRequiredRatings(AssessmentRatingBulkImportConfig config,
                                                           Sheet sheet) {
        EntityKind subjectKind = EntityKind.valueOf(dsl
                .select(ASSESSMENT_DEFINITION.ENTITY_KIND)
                .from(ASSESSMENT_DEFINITION)
                .where(ASSESSMENT_DEFINITION.ID.eq(config.assessmentDefinitionId()))
                .fetchOne(ASSESSMENT_DEFINITION.ENTITY_KIND));

        Aliases<Long> ratingAliases = mkRatingAliases(config);

        Map<String, Long> externalIdToEntityIdMap = loadExternalIdToEntityIdMap(subjectKind);

        StreamUtilities.Siphon<Tuple5<String, String, String, Long, Optional<Long>>> noEntityFoundSiphon = mkSiphon(t -> t.v4 == null);
        StreamUtilities.Siphon<Tuple5<String, String, String, Long, Optional<Long>>> noRatingFoundSiphon = mkSiphon(t -> !t.v5.isPresent());

        Set<AssessmentRatingEntry> requiredRatings = streamRows(sheet)
                .skip(config.numberOfHeaderRows())
                .map(r -> tuple(
                        strVal(r, Columns.A),
                        strVal(r, Columns.B),
                        strVal(r, Columns.C)))
                .map(t -> t.concat(tuple(externalIdToEntityIdMap.get(t.v1), ratingAliases.lookup(t.v2))))
                .filter(noEntityFoundSiphon)
                .filter(noRatingFoundSiphon)
                .map(t -> ImmutableAssessmentRatingEntry.builder()
                        .entity(mkRef(subjectKind, t.v4))
                        .ratingId(t.v5.get())
                        .description(t.v3)
                        .build())
                .collect(toSet());

        noEntityFoundSiphon.getResults().forEach(t -> System.out.printf("Couldn't find an entity id for row: %s%n", t.limit3()));
        noRatingFoundSiphon.getResults().forEach(t -> System.out.printf("Couldn't find a rating id for row: %s%n", t.limit3()));
        return requiredRatings;
    }


    private Map<String, Long> loadExternalIdToEntityIdMap(EntityKind subjectKind) {

        switch (subjectKind){
            case APPLICATION:
                return fetchAppAssetCodeToIdMap();
            case CHANGE_INITIATIVE:
                return fetchChangeInitiativeExtidToIdMap();
            case PHYSICAL_SPECIFICATION:
                return getPhysicalSpecExtIdToIdMap();
            case CHANGE_UNIT:
                return getChangeUnitExtIdToIdMap();
            case LICENCE:
                return fetchLicenceExtIdToIdMap();
            default:
                throw new IllegalStateException(format("Cannot look up external id to name map for EntityKind: %s", subjectKind));
        }

    }


    private Map<String, Long> fetchLicenceExtIdToIdMap() {
        return dsl
                .select(LICENCE.EXTERNAL_ID, LICENCE.ID)
                .from(LICENCE)
                .fetchMap(
                        r -> r.get(LICENCE.EXTERNAL_ID).toLowerCase(),
                        r -> r.get(LICENCE.ID));
    }


    private Map<String, Long> getChangeUnitExtIdToIdMap() {
        return dsl
                .select(CHANGE_UNIT.EXTERNAL_ID, CHANGE_UNIT.ID)
                .from(CHANGE_UNIT)
                .fetchMap(
                        r -> r.get(CHANGE_UNIT.EXTERNAL_ID).toLowerCase(),
                        r -> r.get(CHANGE_UNIT.ID));
    }


    private Map<String, Long> getPhysicalSpecExtIdToIdMap() {
        return dsl
                .select(PHYSICAL_SPECIFICATION.EXTERNAL_ID, PHYSICAL_SPECIFICATION.ID)
                .from(PHYSICAL_SPECIFICATION)
                .fetchMap(
                        r -> r.get(PHYSICAL_SPECIFICATION.EXTERNAL_ID).toLowerCase(),
                        r -> r.get(PHYSICAL_SPECIFICATION.ID));
    }


    private Map<String, Long> fetchChangeInitiativeExtidToIdMap() {
        return dsl
                .select(CHANGE_INITIATIVE.EXTERNAL_ID, CHANGE_INITIATIVE.ID)
                .from(CHANGE_INITIATIVE)
                .fetchMap(r -> r.get(CHANGE_INITIATIVE.EXTERNAL_ID).toLowerCase(),
                        r -> r.get(CHANGE_INITIATIVE.ID));
    }


    private Map<String, Long> fetchAppAssetCodeToIdMap() {
        return dsl
                .select(APPLICATION.ASSET_CODE, APPLICATION.ID)
                .from(APPLICATION)
                .fetchMap(
                        r -> r.get(APPLICATION.ASSET_CODE).toLowerCase(),
                        r -> r.get(APPLICATION.ID));
    }


    private Aliases<Long> mkRatingAliases(AssessmentRatingBulkImportConfig config) {
        Aliases<Long> ratingAliases = new Aliases<>();

        dsl
                .select(RATING_SCHEME_ITEM.CODE, RATING_SCHEME_ITEM.NAME, RATING_SCHEME_ITEM.ID)
                .from(RATING_SCHEME_ITEM)
                .innerJoin(ASSESSMENT_DEFINITION).on(RATING_SCHEME_ITEM.SCHEME_ID.eq(ASSESSMENT_DEFINITION.RATING_SCHEME_ID))
                .where(ASSESSMENT_DEFINITION.ID.eq(config.assessmentDefinitionId()))
                .forEach(r -> {
                    Long val = r.get(RATING_SCHEME_ITEM.ID);
                    ratingAliases.register(val, r.get(RATING_SCHEME_ITEM.NAME));
                    ratingAliases.register(val, r.get(RATING_SCHEME_ITEM.CODE));
                });
        return ratingAliases;
    }


    private AssessmentRatingRecord mkAssessmentRatingRecord(Long defnId,
                                                            AssessmentRatingEntry r,
                                                            String updateUser) {

        AssessmentRatingRecord record = dsl.newRecord(ASSESSMENT_RATING);
        record.setAssessmentDefinitionId(defnId);
        record.setEntityId(r.entity().id());
        record.setEntityKind(r.entity().kind().name());
        record.setRatingId(r.ratingId());
        record.setLastUpdatedAt(DateTimeUtilities.nowUtcTimestamp());
        record.setLastUpdatedBy(updateUser);
        record.setDescription(r.description());
        record.setProvenance(PROVENANCE);
        return record;
    }


    // -- MAIN ------------------------------------------------------

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfiguration.class);
        AssessmentRatingBulkImport importer = ctx.getBean(AssessmentRatingBulkImport.class);

        String filename = "/assessment_rating_upload.xlsx";

        AssessmentRatingBulkImportConfig config = ImmutableAssessmentRatingBulkImportConfig.builder()
                .assessmentDefinitionId(4L)
                .numberOfHeaderRows(0)
                .sheetPosition(0)
                .updateUser(PROVENANCE)
                .mode(SynchronisationMode.FULL)
                .build();

        importer.load(filename, config);
    }

}
