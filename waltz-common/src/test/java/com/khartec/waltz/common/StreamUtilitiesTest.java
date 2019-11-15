package com.khartec.waltz.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class StreamUtilitiesTest {

  @Test
  public void concatTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    ArrayList<Object> arrayList1 = new ArrayList<Object>();
    arrayList1.add("aaaaa");
    ArrayList<Object> arrayList2 = new ArrayList<Object>();
    arrayList2.add("aakaa");
    Collection<Object>[] collectionArray = new Collection[]{arrayList, arrayList1, arrayList2};

    // Act
    StreamUtilities.<Object>concat(collectionArray);

    // Assert
    assertEquals(3, collectionArray.length);
  }

  @Test
  public void ofNullableArrayTest() throws Exception {
    // Arrange
    Object[] objectArray = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    StreamUtilities.<Object>ofNullableArray(objectArray);

    // Assert
    assertEquals(3, objectArray.length);
  }
}
