package com.khartec.waltz.common.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsufficientPrivelegeExceptionTest {
  @Test
  public void InsufficientPrivelegeExceptionTest() throws Exception {
    // Arrange
    String message = "aaaaa";

    // Act
    InsufficientPrivelegeException insufficientPrivelegeException = new InsufficientPrivelegeException(message);

    // Assert
    assertEquals("com.khartec.waltz.common.exception.InsufficientPrivelegeException: aaaaa",
        insufficientPrivelegeException.toString());
  }
}
