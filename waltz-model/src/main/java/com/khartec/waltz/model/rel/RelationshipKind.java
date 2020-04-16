package com.khartec.waltz.model.rel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.khartec.waltz.model.LastUpdatedUserTimestampProvider;
import com.khartec.waltz.model.ProvenanceProvider;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as=ImmutableRelationshipKind.class)
@JsonDeserialize(as=ImmutableRelationshipKind.class)
public abstract class RelationshipKind implements ProvenanceProvider, LastUpdatedUserTimestampProvider {

    public abstract String kind();


}
