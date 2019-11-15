package com.khartec.waltz.data.orgunit;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OrganisationalUnitIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void mkForOptionsTest() throws Exception {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory = new OrganisationalUnitIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    organisationalUnitIdSelectorFactory.mkForOptions(options);
  }
}
