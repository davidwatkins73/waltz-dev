package com.khartec.waltz.data.bookmark;

import com.khartec.waltz.model.ImmutableIdSelectionOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookmarkIdSelectorFactoryTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void applyTest() throws Exception {
    // Arrange
    BookmarkIdSelectorFactory bookmarkIdSelectorFactory = new BookmarkIdSelectorFactory();
    ImmutableIdSelectionOptions selectionOptions = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    bookmarkIdSelectorFactory.apply(selectionOptions);
  }
}
