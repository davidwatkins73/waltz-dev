package com.khartec.waltz.data.rel.change_initiative_to_measurable;

import com.khartec.waltz.model.EntityLifecycleStatus;
import com.khartec.waltz.model.measurable.Measurable;
import com.khartec.waltz.schema.tables.RelChangeInitiativeToMeasurable;
import com.khartec.waltz.schema.tables.RelChangeInitiativeToMeasurableDecorator;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;

import java.util.List;

import static com.khartec.waltz.schema.Tables.REL_CHANGE_INITIATIVE_TO_MEASURABLE;
import static com.khartec.waltz.schema.Tables.REL_CHANGE_INITIATIVE_TO_MEASURABLE_DECORATOR;
import static com.khartec.waltz.schema.tables.Measurable.MEASURABLE;
import static org.jooq.lambda.tuple.Tuple.tuple;

/**
 create table rel_measurable_to_measurable
 (
 id bigserial not null
 constraint rel_measurable_to_measurable_pk
 primary key,
 measurable_a_id bigint    not null
 constraint rm2m_ma_fk
 references measurable,
 measurable_b_id  bigint    not null
 constraint rm2m_mb_fk
 references measurable
 );

 alter table rel_measurable_to_measurable
 owner to postgres;

 create unique index rm2m_uindex
 on rel_measurable_to_measurable (measurable_a_id, measurable_b_id);

 -- auto-generated definition
 create table rel_change_initiative_to_measurable
 (
 id                   bigserial not null
 constraint rel_change_initiative_to_measurable_pk
 primary key,
 change_initiative_id bigint    not null
 constraint rci2m_ci_fk
 references change_initiative,
 measurable_id        bigint    not null
 constraint rci2m_m_fk
 references measurable
 );

 alter table rel_change_initiative_to_measurable
 owner to postgres;

 create unique index rci2m_uindex
 on rel_change_initiative_to_measurable (change_initiative_id, measurable_id);


 */
public class ChangeInitiativeToMeasurableRelationshipDao {

    public List<Measurable> findMeasurableRelationshipsByCiId(DSLContext dsl,
                                                              Select<Record1<Long>> ciSelector) {
        RelChangeInitiativeToMeasurable relationship = REL_CHANGE_INITIATIVE_TO_MEASURABLE.as("rel");
        RelChangeInitiativeToMeasurableDecorator decorator = REL_CHANGE_INITIATIVE_TO_MEASURABLE_DECORATOR.as("dec");

        dsl
            .select(relationship.ID,
                    relationship.CHANGE_INITIATIVE_ID,
                    relationship.MEASURABLE_ID)
            .select(decorator.fields())
            .from(relationship)
            .innerJoin(MEASURABLE)
            .on(relationship.MEASURABLE_ID.eq(MEASURABLE.ID))
            .innerJoin(decorator)
            .on(decorator.RELATIONSHIP_ID.eq(relationship.ID))
            .where(relationship.CHANGE_INITIATIVE_ID.in(ciSelector))
            .and(MEASURABLE.ENTITY_LIFECYCLE_STATUS.notEqual(EntityLifecycleStatus.REMOVED.name()))
            .fetch()
            .stream()
            .map(r -> tuple());

        return null;
    }

}
