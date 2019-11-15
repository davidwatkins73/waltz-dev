package com.khartec.waltz.data.logical_flow;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LogicalFlowIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    LogicalFlowIdSelectorFactory logicalFlowIdSelectorFactory = new LogicalFlowIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    logicalFlowIdSelectorFactory.apply(options);
  }
}
