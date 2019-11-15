package com.khartec.waltz.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SetUtilitiesTest {

  @Test
  public void asSetTest() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Set<Object> actual = SetUtilities.<Object>asSet(ts);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void fromArrayTest() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Set<Object> actual = SetUtilities.<Object>fromArray(ts);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void fromCollectionTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Set<Object> actual = SetUtilities.<Object>fromCollection(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void intersectionTest() throws Exception {
    // Arrange
    HashSet<Object> hashSet = new HashSet<Object>();
    hashSet.add("aaaaa");
    HashSet<Object> hashSet1 = new HashSet<Object>();
    hashSet1.add("aaaaa");

    // Act
    Set<Object> actual = SetUtilities.<Object>intersection(hashSet, hashSet1);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void minusTest() throws Exception {
    // Arrange
    HashSet<Object> hashSet = new HashSet<Object>();
    hashSet.add("aaaaa");
    HashSet<Object> hashSet1 = new HashSet<Object>();
    hashSet1.add("aaaaa");
    Set<Object>[] yss = new Set[]{hashSet, hashSet1, hashSet};

    // Act
    Set<Object> actual = SetUtilities.<Object>minus(hashSet, yss);

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void orderedUnionTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    ArrayList<Object> arrayList1 = new ArrayList<Object>();
    arrayList1.add("aaaaa");
    ArrayList<Object> arrayList2 = new ArrayList<Object>();
    arrayList2.add("aakaa");
    Collection<Object>[] xss = new Collection[]{arrayList, arrayList1, arrayList2};

    // Act
    Set<Object> actual = SetUtilities.<Object>orderedUnion(xss);

    // Assert
    assertEquals(2, actual.size());
  }

  @Test
  public void unionAllTest() throws Exception {
    // Arrange
    ArrayList<Collection<Object>> arrayList = new ArrayList<Collection<Object>>();
    ArrayList<Object> arrayList1 = new ArrayList<Object>();
    arrayList1.add("aaaaa");
    arrayList.add(arrayList1);

    // Act
    Collection<Object> actual = SetUtilities.<Object>unionAll(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void unionTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    ArrayList<Object> arrayList1 = new ArrayList<Object>();
    arrayList1.add("aaaaa");
    ArrayList<Object> arrayList2 = new ArrayList<Object>();
    arrayList2.add("aakaa");
    Collection<Object>[] xss = new Collection[]{arrayList, arrayList1, arrayList2};

    // Act
    Set<Object> actual = SetUtilities.<Object>union(xss);

    // Assert
    assertEquals(2, actual.size());
  }
}
