package com.khartec.waltz.data.entity_hierarchy;

import com.khartec.waltz.model.EntityKind;
import org.junit.Test;

public class EntityRootsSelectorFactoryTest {  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    EntityRootsSelectorFactory entityRootsSelectorFactory = new EntityRootsSelectorFactory();
    EntityKind entityKind = EntityKind.ACTOR;

    // Act
    entityRootsSelectorFactory.apply(entityKind);
  }
}
