package com.khartec.waltz.common;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CollectionUtilitiesTest {

  @Test
  public void firstTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Object actual = CollectionUtilities.<Object>first(arrayList);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void headTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Optional<Object> actual = CollectionUtilities.<Object>head(arrayList);

    // Assert
    assertEquals("Optional[aaaaa]", actual.toString());
  }

  @Test
  public void isEmptyTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    boolean actual = CollectionUtilities.<Object>isEmpty(arrayList);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void maybeFirstTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Optional<Object> actual = CollectionUtilities.<Object>maybeFirst(arrayList);

    // Assert
    assertEquals("Optional[aaaaa]", actual.toString());
  }

  @Test
  public void notEmptyTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    boolean actual = CollectionUtilities.<Object>notEmpty(arrayList);

    // Assert
    assertTrue(actual);
  }

  @Test
  public void sortTest() throws Exception {
    // Arrange
    ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
    arrayList.add(Whitebox.newInstance(Comparable.class));

    // Act
    List<Comparable> actual = CollectionUtilities.<Comparable>sort(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }
}
