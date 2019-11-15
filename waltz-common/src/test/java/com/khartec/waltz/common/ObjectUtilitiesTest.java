package com.khartec.waltz.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectUtilitiesTest {

  @Test
  public void dumpTest() throws Exception {
    // Arrange
    String x = "aaaaa";

    // Act
    Object actual = ObjectUtilities.<Object>dump(x);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void firstNotNullTest() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Object actual = ObjectUtilities.<Object>firstNotNull(ts);

    // Assert
    assertEquals("aaaaa", actual);
  }
}
