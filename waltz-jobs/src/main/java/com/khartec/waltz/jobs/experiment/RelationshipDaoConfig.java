package com.khartec.waltz.jobs.experiment;

import org.immutables.value.Value;
import org.jooq.Field;
import org.jooq.Table;

@Value.Immutable
public abstract class RelationshipDaoConfig {

    public abstract Table<?> relTable();
    public abstract Table<?> aTable();
    public abstract Table<?> bTable();
    public abstract Field<Long> relIdField();
    public abstract Field<Long> aIdField();
    public abstract Field<Long> bIdField();

}
