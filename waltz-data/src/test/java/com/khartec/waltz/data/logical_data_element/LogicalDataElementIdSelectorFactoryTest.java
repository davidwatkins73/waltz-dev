package com.khartec.waltz.data.logical_data_element;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LogicalDataElementIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    LogicalDataElementIdSelectorFactory logicalDataElementIdSelectorFactory = new LogicalDataElementIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    logicalDataElementIdSelectorFactory.apply(options);
  }
}
