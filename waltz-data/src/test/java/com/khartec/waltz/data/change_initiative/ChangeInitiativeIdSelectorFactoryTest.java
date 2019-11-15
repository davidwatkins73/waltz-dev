package com.khartec.waltz.data.change_initiative;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ChangeInitiativeIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void mkForOptionsTest() throws Exception {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    changeInitiativeIdSelectorFactory.mkForOptions(options);
  }
}
