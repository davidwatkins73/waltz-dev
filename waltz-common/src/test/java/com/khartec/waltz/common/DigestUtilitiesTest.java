package com.khartec.waltz.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigestUtilitiesTest {

  @Test
  public void digestTest() throws Exception {
    // Arrange
    byte[] bytes = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Act
    String actual = DigestUtilities.digest(bytes);

    // Assert
    assertEquals("0zmbcmL7Vsue0FPWjbkpHEEIOcQ=", actual);
  }
}
