package com.khartec.waltz.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class StringUtilitiesTest {

  @Test
  public void firstCharTest() throws Exception {
    // Arrange
    String str = "aaaaa";
    char dflt = 'c';

    // Act
    char actual = StringUtilities.firstChar(str, dflt);

    // Assert
    assertEquals('a', actual);
  }

  @Test
  public void ifEmptyTest() throws Exception {
    // Arrange
    String x = "aaaaa";
    String defaultValue = "aaaaa";

    // Act
    String actual = StringUtilities.ifEmpty(x, defaultValue);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void isEmptyTest() throws Exception {
    // Arrange
    String x = "aaaaa";

    // Act
    boolean actual = StringUtilities.isEmpty(x);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void isEmptyTest2() throws Exception {
    // Arrange
    Optional<String> maybeString = null;

    // Act
    boolean actual = StringUtilities.isEmpty(maybeString);

    // Assert
    assertTrue(actual);
  }

  @Test
  public void joinTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    String separator = "aaaaa";

    // Act
    String actual = StringUtilities.join(arrayList, separator);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void lengthTest() throws Exception {
    // Arrange
    String str = "aaaaa";

    // Act
    int actual = StringUtilities.length(str);

    // Assert
    assertEquals(5, actual);
  }

  @Test
  public void limitTest() throws Exception {
    // Arrange
    String str = "aaaaa";
    int maxLength = 1;

    // Act
    String actual = StringUtilities.limit(str, maxLength);

    // Assert
    assertEquals("a", actual);
  }

  @Test
  public void lowerTest() throws Exception {
    // Arrange
    String value = "aaaaa";

    // Act
    String actual = StringUtilities.lower(value);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void mkSafeTest() throws Exception {
    // Arrange
    String str = "aaaaa";

    // Act
    String actual = StringUtilities.mkSafe(str);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void notEmptyTest() throws Exception {
    // Arrange
    String x = "aaaaa";

    // Act
    boolean actual = StringUtilities.notEmpty(x);

    // Assert
    assertTrue(actual);
  }

  @Test
  public void parseIntegerTest() throws Exception {
    // Arrange
    String value = "aaaaa";
    Integer dflt = new Integer(1);

    // Act
    Integer actual = StringUtilities.parseInteger(value, dflt);

    // Assert
    assertEquals(Integer.valueOf(1), actual);
  }

  @Test
  public void parseLongTest() throws Exception {
    // Arrange
    String value = "aaaaa";
    Long dflt = new Long(1L);

    // Act
    Long actual = StringUtilities.parseLong(value, dflt);

    // Assert
    assertEquals(Long.valueOf(1L), actual);
  }

  @Test
  public void toOptionalTest() throws Exception {
    // Arrange
    String str = "aaaaa";

    // Act
    Optional<String> actual = StringUtilities.toOptional(str);

    // Assert
    assertEquals("Optional[aaaaa]", actual.toString());
  }

  @Test
  public void tokeniseTest() throws Exception {
    // Arrange
    String value = "aaaaa";
    String regex = "aaaaa";

    // Act
    List<String> actual = StringUtilities.tokenise(value, regex);

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void tokeniseTest2() throws Exception {
    // Arrange
    String value = "aaaaa";

    // Act
    List<String> actual = StringUtilities.tokenise(value);

    // Assert
    assertEquals(1, actual.size());
  }
}
