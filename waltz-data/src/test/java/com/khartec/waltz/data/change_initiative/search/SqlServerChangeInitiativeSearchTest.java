package com.khartec.waltz.data.change_initiative.search;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SqlServerChangeInitiativeSearchTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void searchTest() throws Exception {
    // Arrange
    SqlServerChangeInitiativeSearch sqlServerChangeInitiativeSearch = new SqlServerChangeInitiativeSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    sqlServerChangeInitiativeSearch.search(dsl, query, options);
  }
}
