package com.khartec.waltz.data.server_information.search;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MariaServerInformationSearchTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void searchTest() throws Exception {
    // Arrange
    MariaServerInformationSearch mariaServerInformationSearch = new MariaServerInformationSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    mariaServerInformationSearch.search(dsl, query, options);
  }
}
