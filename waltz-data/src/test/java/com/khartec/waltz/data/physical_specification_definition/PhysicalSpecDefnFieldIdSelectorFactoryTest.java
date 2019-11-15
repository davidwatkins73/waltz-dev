package com.khartec.waltz.data.physical_specification_definition;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PhysicalSpecDefnFieldIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    PhysicalSpecDefnFieldIdSelectorFactory physicalSpecDefnFieldIdSelectorFactory = new PhysicalSpecDefnFieldIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalSpecDefnFieldIdSelectorFactory.apply(options);
  }
}
