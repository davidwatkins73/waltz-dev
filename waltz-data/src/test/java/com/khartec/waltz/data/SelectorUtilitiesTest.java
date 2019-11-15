package com.khartec.waltz.data;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SelectorUtilitiesTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void ensureScopeIsExactTest() throws Exception {
    // Arrange
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    SelectorUtilities.<com.khartec.waltz.model.IdSelectionOptions>ensureScopeIsExact(options);
  }

  @Test
  public void mkApplicationConditionsTest() throws Exception {
    // Arrange
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    SelectorUtilities.mkApplicationConditions(options);
  }
}
