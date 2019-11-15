package com.khartec.waltz.data.physical_flow;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PhysicalFlowIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalFlowIdSelectorFactory.apply(options);
  }
}
