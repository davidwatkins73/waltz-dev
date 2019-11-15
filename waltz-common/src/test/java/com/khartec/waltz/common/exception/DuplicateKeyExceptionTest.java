package com.khartec.waltz.common.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateKeyExceptionTest {
  @Test
  public void DuplicateKeyExceptionTest() throws Exception {
    // Arrange
    String message = "aaaaa";

    // Act
    DuplicateKeyException duplicateKeyException = new DuplicateKeyException(message);

    // Assert
    assertEquals("com.khartec.waltz.common.exception.DuplicateKeyException: aaaaa", duplicateKeyException.toString());
  }

  @Test
  public void DuplicateKeyExceptionTest2() throws Exception {
    // Arrange
    String message = "aaaaa";
    Throwable cause = new Throwable();

    // Act
    DuplicateKeyException duplicateKeyException = new DuplicateKeyException(message, cause);

    // Assert
    assertEquals("com.khartec.waltz.common.exception.DuplicateKeyException: aaaaa", duplicateKeyException.toString());
  }
}
