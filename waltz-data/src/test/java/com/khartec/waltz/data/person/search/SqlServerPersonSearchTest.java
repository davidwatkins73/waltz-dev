package com.khartec.waltz.data.person.search;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SqlServerPersonSearchTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void searchTest() throws Exception {
    // Arrange
    SqlServerPersonSearch sqlServerPersonSearch = new SqlServerPersonSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    sqlServerPersonSearch.search(dsl, query, options);
  }
}
