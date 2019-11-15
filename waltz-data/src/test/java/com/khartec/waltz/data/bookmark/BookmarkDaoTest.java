package com.khartec.waltz.data.bookmark;

import com.khartec.waltz.data.ImmutableGenericSelector;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.bookmark.ImmutableBookmark;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BookmarkDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void BookmarkDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    // Assert
    assertEquals("BookmarkDao{}", bookmarkDao.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableBookmark bookmark = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    bookmarkDao.create(bookmark, username);
  }

  @Test
  public void deleteByIdTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    bookmarkDao.deleteById(id);
  }

  @Test
  public void deleteByParentSelectorTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector parentRefSelector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    bookmarkDao.deleteByParentSelector(parentRefSelector);
  }

  @Test
  public void findByReferenceTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference reference = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    bookmarkDao.findByReference(reference);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    long bookmarkId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    bookmarkDao.getById(bookmarkId);
  }

  @Test
  public void toStringTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act
    String actual = bookmarkDao.toString();

    // Assert
    assertEquals("BookmarkDao{}", actual);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableBookmark bookmark = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    bookmarkDao.update(bookmark, username);
  }
}
