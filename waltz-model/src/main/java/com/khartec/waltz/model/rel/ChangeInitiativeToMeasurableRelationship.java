package com.khartec.waltz.model.rel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.khartec.waltz.model.EntityKindProvider;
import com.khartec.waltz.model.EntityReference;
import com.khartec.waltz.model.IdProvider;
import com.khartec.waltz.model.WaltzEntity;
import org.immutables.value.Value;

import java.util.Set;

@Value.Immutable
@JsonSerialize(as = ImmutableChangeInitiativeToMeasurableRelationship.class)
@JsonDeserialize(as = ImmutableChangeInitiativeToMeasurableRelationship.class)
public abstract class ChangeInitiativeToMeasurableRelationship implements IdProvider, EntityKindProvider, WaltzEntity {

    public abstract Long changeInitiativeId();
    public abstract Long measurableId();
    public abstract Set<RelationshipKind> kinds();

    @Override
    public EntityReference entityReference() {
        return EntityReference.mkRef(
                kind(),
                id().get());
    }
}
