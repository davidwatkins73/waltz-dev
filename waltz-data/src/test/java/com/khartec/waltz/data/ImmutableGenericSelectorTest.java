package com.khartec.waltz.data;

import com.khartec.waltz.data.ImmutableGenericSelector;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ImmutableGenericSelectorTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void builderTest() throws Exception {
    // Arrange and Act
    ImmutableGenericSelector.builder();
  }

  @Test
  public void copyOfTest() throws Exception {
    // Arrange
    ImmutableGenericSelector instance = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    ImmutableGenericSelector.copyOf(instance);
  }
}
