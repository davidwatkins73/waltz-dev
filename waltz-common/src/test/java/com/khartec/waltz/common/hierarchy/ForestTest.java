package com.khartec.waltz.common.hierarchy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ForestTest {
  @Test
  public void ForestTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>(string, "aaaaaaaaaaaaaaa"));

    // Act
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Assert
    assertEquals("Forest{#allNodes=1, rootNodes=[Node{id=aaaaa, #children=0}]}", forest.toString());
  }

  @Test
  public void getAllNodesTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>("aaaaa", "aaaaa"));
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Act
    forest.getAllNodes();

    // Assert
    assertEquals("Forest{#allNodes=1, rootNodes=[Node{id=aaaaa, #children=0}]}", forest.toString());
  }

  @Test
  public void getRootNodesTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>("aaaaa", "aaaaa"));
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Act
    forest.getRootNodes();

    // Assert
    assertEquals("Forest{#allNodes=1, rootNodes=[Node{id=aaaaa, #children=0}]}", forest.toString());
  }

  @Test
  public void toStringTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>("aaaaa", "aaaaa"));
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Act
    String actual = forest.toString();

    // Assert
    assertEquals("Forest{#allNodes=1, rootNodes=[Node{id=aaaaa, #children=0}]}", actual);
  }
}
