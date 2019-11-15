package com.khartec.waltz.data;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MSSQLTest {  
  @Test
  public void mkContainsPrefixTest() throws Exception {
    // Arrange
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("aaaaa");

    // Act
    JooqUtilities.MSSQL.mkContainsPrefix(arrayList);

    // Assert
    assertEquals(1, arrayList.size());
  }

  @Test
  public void mkContainsTest() throws Exception {
    // Arrange
    String[] stringArray = new String[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    JooqUtilities.MSSQL.mkContains(stringArray);

    // Assert
    assertEquals(3, stringArray.length);
  }

  @Test
  public void mkContainsTest2() throws Exception {
    // Arrange
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("aaaaa");

    // Act
    JooqUtilities.MSSQL.mkContains(arrayList);

    // Assert
    assertEquals(1, arrayList.size());
  }
}
