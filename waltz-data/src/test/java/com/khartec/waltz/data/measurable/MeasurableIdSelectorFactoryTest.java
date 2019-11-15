package com.khartec.waltz.data.measurable;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MeasurableIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableIdSelectorFactory.apply(options);
  }
}
