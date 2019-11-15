package com.khartec.waltz.data;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GenericSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyForKindTest() throws Exception {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityKind targetKind = EntityKind.ACTOR;
    ImmutableIdSelectionOptions selectionOptions = null;

    // Act and Assert
    thrown.expect(UnsupportedOperationException.class);
    genericSelectorFactory.applyForKind(targetKind, selectionOptions);
  }

  @Test
  public void applyTest() throws Exception {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    ImmutableIdSelectionOptions selectionOptions = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    genericSelectorFactory.apply(selectionOptions);
  }
}
