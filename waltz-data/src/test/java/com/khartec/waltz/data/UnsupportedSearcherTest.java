package com.khartec.waltz.data;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnsupportedSearcherTest {
  @Test
  public void UnsupportedSearcherTest() throws Exception {
    // Arrange
    SQLDialect dialect = SQLDialect.SQL99;

    // Act
    new UnsupportedSearcher<Object>(dialect);
  }

  @Test
  public void searchTest() throws Exception {
    // Arrange
    UnsupportedSearcher<Object> unsupportedSearcher = new UnsupportedSearcher<Object>(SQLDialect.SQL99);
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String terms = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act
    List<Object> actual = unsupportedSearcher.search(dsl, terms, options);

    // Assert
    assertEquals(0, actual.size());
  }
}
