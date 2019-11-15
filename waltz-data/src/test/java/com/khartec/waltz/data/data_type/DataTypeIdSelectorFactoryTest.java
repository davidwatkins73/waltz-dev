package com.khartec.waltz.data.data_type;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataTypeIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void mkForOptionsTest() throws Exception {
    // Arrange
    DataTypeIdSelectorFactory dataTypeIdSelectorFactory = new DataTypeIdSelectorFactory();
    ImmutableIdSelectionOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    dataTypeIdSelectorFactory.mkForOptions(options);
  }
}
