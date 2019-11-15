package com.khartec.waltz.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListUtilitiesTest {

  @Test
  public void appendTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    String t = "aaaaa";

    // Act
    List<Object> actual = ListUtilities.<Object>append(arrayList, t);

    // Assert
    assertEquals(2, actual.size());
  }

  @Test
  public void asListTest() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    List<Object> actual = ListUtilities.<Object>asList(ts);

    // Assert
    assertEquals(3, actual.size());
  }

  @Test
  public void builderTest() throws Exception {
    // Arrange
    Class<Object> cls = null;

    // Act
    ListUtilities.<Object>builder(cls);
  }

  @Test
  public void compactTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    List<Object> actual = ListUtilities.<Object>compact(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void concatTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    ArrayList<Object> arrayList1 = new ArrayList<Object>();
    arrayList1.add("aaaaa");
    ArrayList<Object> arrayList2 = new ArrayList<Object>();
    arrayList2.add("aakaa");
    List<Object>[] tss = new List[]{arrayList, arrayList1, arrayList2};

    // Act
    List<Object> actual = ListUtilities.<Object>concat(tss);

    // Assert
    assertEquals(3, actual.size());
  }

  @Test
  public void dropTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    int count = 1;

    // Act
    List<Object> actual = ListUtilities.<Object>drop(arrayList, count);

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void ensureNotNullTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    List<Object> actual = ListUtilities.<Object>ensureNotNull(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void integerRangeTest() throws Exception {
    // Arrange
    int startInclusive = 1;
    int endExclusive = 1;

    // Act
    List<Integer> actual = ListUtilities.integerRange(startInclusive, endExclusive);

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void isEmptyTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    boolean actual = ListUtilities.<Object>isEmpty(arrayList);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void newArrayListTest() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    ArrayList<Object> actual = ListUtilities.<Object>newArrayList(ts);

    // Assert
    assertEquals(3, actual.size());
  }

  @Test
  public void pushTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    String string = "aaaaa";
    arrayList.add(string);
    Object[] elems = new Object[]{"aaaaa", string, "aaaaa"};

    // Act
    List<Object> actual = ListUtilities.<Object>push(arrayList, elems);

    // Assert
    assertEquals(4, actual.size());
  }

  @Test
  public void reverseTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    List<Object> actual = ListUtilities.<Object>reverse(arrayList);

    // Assert
    assertEquals(1, actual.size());
  }
}
