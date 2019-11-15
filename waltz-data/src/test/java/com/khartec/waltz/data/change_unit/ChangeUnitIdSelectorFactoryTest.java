package com.khartec.waltz.data.change_unit;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ChangeUnitIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    ChangeUnitIdSelectorFactory changeUnitIdSelectorFactory = new ChangeUnitIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    changeUnitIdSelectorFactory.apply(options);
  }
}
