package com.khartec.waltz.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalUtilitiesTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void contentsEqualTest() throws Exception {
    // Arrange
    Optional<Object> opt = null;
    String val = "aaaaa";

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    OptionalUtilities.<Object>contentsEqual(opt, val);
  }

  @Test
  public void maybeTest() throws Exception {
    // Arrange
    String value = "aaaaa";

    // Act
    Optional<Object> actual = OptionalUtilities.<Object>maybe(value);

    // Assert
    assertEquals("Optional[aaaaa]", actual.toString());
  }

  @Test
  public void ofNullableOptionalTest() throws Exception {
    // Arrange
    Optional<Object> nullable = null;

    // Act
    Optional<Object> actual = OptionalUtilities.<Object>ofNullableOptional(nullable);

    // Assert
    assertEquals("Optional.empty", actual.toString());
  }

  @Test
  public void toListTest() throws Exception {
    // Arrange
    Optional<Object>[] optionals = new Optional[]{null, null, null};

    // Act and Assert
    thrown.expect(NullPointerException.class);
    OptionalUtilities.<Object>toList(optionals);
  }
}
