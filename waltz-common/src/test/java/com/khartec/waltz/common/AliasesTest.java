package com.khartec.waltz.common;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AliasesTest {

  @Test
  public void lookupTest() throws Exception {
    // Arrange
    Aliases<Object> aliases = new Aliases<Object>();
    String alias = "aaaaa";

    // Act
    Optional<Object> actual = aliases.lookup(alias);

    // Assert
    assertEquals("Optional.empty", actual.toString());
  }

  @Test
  public void registerTest() throws Exception {
    // Arrange
    Aliases<Object> aliases = new Aliases<Object>();
    String val = "aaaaa";
    String[] stringArray = new String[]{"aaaaa", "aaaaa", "aakaa"};

    // Act
    aliases.register(val, stringArray);

    // Assert
    assertEquals(3, stringArray.length);
  }
}
