package com.khartec.waltz.data.entity_hierarchy;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class EntityHierarchyDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void EntityHierarchyDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new EntityHierarchyDao(dsl);
  }

  @Test
  public void getRootTalliesTest() throws Exception {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityHierarchyDao.getRootTallies();
  }

  @Test
  public void replaceHierarchyTest() throws Exception {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind kind = EntityKind.ACTOR;
    ArrayList<EntityHierarchyItem> arrayList = new ArrayList<EntityHierarchyItem>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityHierarchyDao.replaceHierarchy(kind, arrayList);
  }

  @Test
  public void tallyByKindTest() throws Exception {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityHierarchyDao.tallyByKind();
  }
}
