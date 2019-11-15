package com.khartec.waltz.common.hierarchy;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class NodeTest {
  @Test
  public void NodeTest() throws Exception {
    // Arrange
    String id = "aaaaa";
    String data = "aaaaa";

    // Act
    Node<Object, Object> node = new Node<Object, Object>(id, data);

    // Assert
    String toStringResult = node.toString();
    Object data1 = node.getData();
    assertEquals("Node{id=aaaaa, #children=0}", toStringResult);
    assertEquals(null, node.getParent());
    assertTrue(data1 instanceof String);
  }

  @Test
  public void addChildTest() throws Exception {
    // Arrange
    String string = "aaaaa";
    String string1 = "aaaaa";
    Node<Object, Object> node = new Node<Object, Object>(string, string1);
    Node childNode = new Node(string, string1);

    // Act
    Node actual = node.addChild(childNode);

    // Assert
    assertEquals("Node{id=aaaaa, #children=1}", actual.toString());
  }

  @Test
  public void getChildrenTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    Set<Node<Object, Object>> actual = node.getChildren();

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void getDataTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    Object actual = node.getData();

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void getIdTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    Object actual = node.getId();

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void getParentTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    Node<Object, Object> actual = node.getParent();

    // Assert
    assertEquals(null, actual);
  }

  @Test
  public void setParentTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    Node actual = node.setParent(node);

    // Assert
    assertSame(actual, actual.getParent());
  }

  @Test
  public void toStringTest() throws Exception {
    // Arrange
    Node<Object, Object> node = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    String actual = node.toString();

    // Assert
    assertEquals("Node{id=aaaaa, #children=0}", actual);
  }
}
