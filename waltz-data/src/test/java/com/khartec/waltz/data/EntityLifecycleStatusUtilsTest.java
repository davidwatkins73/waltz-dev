package com.khartec.waltz.data;

import com.khartec.waltz.model.EntityLifecycleStatus;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EntityLifecycleStatusUtilsTest {  
  @Test
  public void convertToIsRemovedFlagsTest() throws Exception {
    // Arrange
    HashSet<EntityLifecycleStatus> hashSet = new HashSet<EntityLifecycleStatus>();
    hashSet.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Boolean> actual = EntityLifecycleStatusUtils.convertToIsRemovedFlags(hashSet);

    // Assert
    assertEquals(2, actual.size());
  }
}
