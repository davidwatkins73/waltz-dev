package com.khartec.waltz.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ArrayUtilitiesTest {

  @Test
  public void initialTest() throws Exception {
    // Arrange
    Object[] bits = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Object[] actual = ArrayUtilities.<Object>initial(bits);

    // Assert
    assertEquals(2, actual.length);
  }

  @Test
  public void isEmptyTest() throws Exception {
    // Arrange
    Object[] arr = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    boolean actual = ArrayUtilities.<Object>isEmpty(arr);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void lastTest() throws Exception {
    // Arrange
    Object[] arr = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Object actual = ArrayUtilities.<Object>last(arr);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void sumTest() throws Exception {
    // Arrange
    int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 655361};

    // Act
    int actual = ArrayUtilities.sum(arr);

    // Assert
    assertEquals(655368, actual);
  }
}
