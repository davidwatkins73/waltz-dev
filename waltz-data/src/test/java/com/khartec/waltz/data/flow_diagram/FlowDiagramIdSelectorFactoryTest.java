package com.khartec.waltz.data.flow_diagram;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FlowDiagramIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    FlowDiagramIdSelectorFactory flowDiagramIdSelectorFactory = new FlowDiagramIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    flowDiagramIdSelectorFactory.apply(options);
  }
}
