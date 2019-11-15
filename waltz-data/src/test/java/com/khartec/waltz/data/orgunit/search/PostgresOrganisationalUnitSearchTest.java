package com.khartec.waltz.data.orgunit.search;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PostgresOrganisationalUnitSearchTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void searchTest() throws Exception {
    // Arrange
    PostgresOrganisationalUnitSearch postgresOrganisationalUnitSearch = new PostgresOrganisationalUnitSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String terms = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    postgresOrganisationalUnitSearch.search(dsl, terms, options);
  }
}
