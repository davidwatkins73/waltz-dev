package com.khartec.waltz.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

  @Test
  public void addAllTest() throws Exception {
    // Arrange
    ListUtilities.Builder<Object> builder = new ListUtilities.Builder<Object>();
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    builder.addAll(arrayList);

    // Assert
    assertEquals(1, arrayList.size());
  }

  @Test
  public void addAllTest2() throws Exception {
    // Arrange
    ListUtilities.Builder<Object> builder = new ListUtilities.Builder<Object>();
    Object[] objectArray = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    builder.addAll(objectArray);

    // Assert
    assertEquals(3, objectArray.length);
  }

  @Test
  public void buildTest() throws Exception {
    // Arrange
    ListUtilities.Builder<Object> builder = new ListUtilities.Builder<Object>();

    // Act
    List<Object> actual = builder.build();

    // Assert
    assertEquals(0, actual.size());
  }
}
