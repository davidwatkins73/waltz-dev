package com.khartec.waltz.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DebugUtilitiesTest {

  @Test
  public void dumpTest() throws Exception {
    // Arrange
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("aaaaa", "aaaaa");

    // Act
    Map<Object, Object> actual = DebugUtilities.<Object, Object>dump(hashMap);

    // Assert
    assertTrue(actual instanceof HashMap);
  }

  @Test
  public void logValueTest() throws Exception {
    // Arrange
    String string = "aaaaa";
    Object[] ctx = new Object[]{"aaaaa", string, "aaaaa"};

    // Act
    Object actual = DebugUtilities.<Object>logValue(string, ctx);

    // Assert
    assertEquals("aaaaa", actual);
  }
}
