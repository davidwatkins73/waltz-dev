package com.khartec.waltz.common.hierarchy;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlatNodeTest {
  @Test
  public void FlatNodeTest() throws Exception {
    // Arrange
    String id = "aaaaa";
    Optional<Object> parentId = null;
    String data = "aaaaa";

    // Act
    FlatNode<Object, Object> flatNode = new FlatNode<Object, Object>(id, parentId, data);

    // Assert
    Optional<Object> parentId1 = flatNode.getParentId();
    Object data1 = flatNode.getData();
    assertEquals(null, parentId1);
    assertTrue(flatNode.getId() instanceof String);
    assertTrue(data1 instanceof String);
  }

  @Test
  public void getDataTest() throws Exception {
    // Arrange
    FlatNode<Object, Object> flatNode = new FlatNode<Object, Object>("aaaaa", null, "aaaaa");

    // Act
    Object actual = flatNode.getData();

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void getIdTest() throws Exception {
    // Arrange
    FlatNode<Object, Object> flatNode = new FlatNode<Object, Object>("aaaaa", null, "aaaaa");

    // Act
    Object actual = flatNode.getId();

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void getParentIdTest() throws Exception {
    // Arrange
    FlatNode<Object, Object> flatNode = new FlatNode<Object, Object>("aaaaa", null, "aaaaa");

    // Act
    Optional<Object> actual = flatNode.getParentId();

    // Assert
    assertEquals(null, actual);
  }
}
