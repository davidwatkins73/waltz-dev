package com.khartec.waltz.data.physical_specification;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PhysicalSpecificationIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory = new PhysicalSpecificationIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalSpecificationIdSelectorFactory.apply(options);
  }
}
