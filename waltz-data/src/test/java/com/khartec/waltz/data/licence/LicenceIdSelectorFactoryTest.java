package com.khartec.waltz.data.licence;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LicenceIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void mkForOptionsTest() throws Exception {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    licenceIdSelectorFactory.mkForOptions(options);
  }
}
