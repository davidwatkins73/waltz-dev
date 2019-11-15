package com.khartec.waltz.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ChecksTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void checkFalseTest() throws Exception {
    // Arrange
    boolean b = true;
    String message = "aaaaa";

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    Checks.checkFalse(b, message);
  }

  @Test
  public void checkNotEmptyTest() throws Exception {
    // Arrange
    String str = "aaaaa";
    String message = "aaaaa";

    // Act
    String actual = Checks.checkNotEmpty(str, message);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void checkNotEmptyTest2() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    String message = "aaaaa";

    // Act
    Checks.<Object>checkNotEmpty(arrayList, message);

    // Assert
    assertEquals(1, arrayList.size());
  }

  @Test
  public void checkNotEmptyTest3() throws Exception {
    // Arrange
    Object[] objectArray = new Object[]{"aaaaa", "aaaaa", "aaaaa"};
    String message = "aaaak";

    // Act
    Checks.<Object>checkNotEmpty(objectArray, message);

    // Assert
    assertEquals(3, objectArray.length);
  }

  @Test
  public void checkNotNullTest() throws Exception {
    // Arrange
    String string = "aaaaa";
    String message = "aaaaa";
    Object[] args = new Object[]{string, "aaaaa", "aaaka"};

    // Act
    Object actual = Checks.<Object>checkNotNull(string, message, args);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void checkOptionalIsPresentTest() throws Exception {
    // Arrange
    Optional<Object> optional = null;
    String message = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    Checks.<Object>checkOptionalIsPresent(optional, message);
  }

  @Test
  public void checkTrueTest() throws Exception {
    // Arrange
    boolean b = true;
    String msg = "aaaaa";
    Object[] objectArray = new Object[]{"aaaaa", "aaaaa", "aaaka"};

    // Act
    Checks.checkTrue(b, msg, objectArray);

    // Assert
    assertEquals(3, objectArray.length);
  }

  @Test
  public void failTest() throws Exception {
    // Arrange
    String msg = "aaaaa";
    Object[] args = new Object[]{"aaaaa", "aaaaa", "aaaak"};

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    Checks.fail(msg, args);
  }

  @Test
  public void mkFailTest() throws Exception {
    // Arrange
    String msg = "aaaaa";
    Object[] args = new Object[]{"aaaaa", "aaaaa", "aaaak"};

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    Checks.mkFail(msg, args);
  }
}
