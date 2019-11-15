package com.khartec.waltz.common.hierarchy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HierarchyUtilitiesTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void assignDepthsTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>("aaaaa", "aaaaa"));
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Act
    Map<Object, Integer> actual = HierarchyUtilities.<Object, Object>assignDepths(forest);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void hasCycleTest() throws Exception {
    // Arrange
    HashMap<Object, Node<Object, Object>> hashMap = new HashMap<Object, Node<Object, Object>>();
    String string = "aaaaa";
    hashMap.put(string, new Node<Object, Object>("aaaaa", string));
    HashSet<Node<Object, Object>> hashSet = new HashSet<Node<Object, Object>>();
    hashSet.add(new Node<Object, Object>("aaaaa", "aaaaa"));
    Forest<Object, Object> forest = new Forest<Object, Object>(hashMap, hashSet);

    // Act
    boolean actual = HierarchyUtilities.<Object, Object>hasCycle(forest);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void parentsTest() throws Exception {
    // Arrange
    Node<Object, Object> startNode = new Node<Object, Object>("aaaaa", "aaaaa");

    // Act
    List<Node<Object, Object>> actual = HierarchyUtilities.<Object, Object>parents(startNode);

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void toForestTest() throws Exception {
    // Arrange
    ArrayList<FlatNode<Object, Object>> arrayList = new ArrayList<FlatNode<Object, Object>>();
    arrayList.add(new FlatNode<Object, Object>("aaaaa", null, "aaaaa"));

    // Act and Assert
    thrown.expect(NullPointerException.class);
    HierarchyUtilities.<Object, Object>toForest(arrayList);
  }
}
