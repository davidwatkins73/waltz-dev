package com.khartec.waltz.data.end_user_app;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EndUserAppIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    endUserAppIdSelectorFactory.apply(options);
  }
}
