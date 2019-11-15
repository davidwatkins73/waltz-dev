package com.khartec.waltz.data.change_initiative.search;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MariaChangeInitiativeSearchTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void searchTest() throws Exception {
    // Arrange
    MariaChangeInitiativeSearch mariaChangeInitiativeSearch = new MariaChangeInitiativeSearch();
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());
    String terms = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    mariaChangeInitiativeSearch.search(dsl, terms, options);
  }
}
