package com.khartec.waltz.data.data_type.search;

import com.khartec.waltz.data.data_type.DataTypeDao;
import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataTypeSearchDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void DataTypeSearchDaoTest() throws Exception {
    // Arrange
    DataTypeDao dataTypeDao = new DataTypeDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act
    new DataTypeSearchDao(dataTypeDao);
  }

  @Test
  public void searchTest() throws Exception {
    // Arrange
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(
        new DataTypeDao(new DefaultDSLContext(new DefaultConfiguration())));
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    dataTypeSearchDao.search(query, options);
  }
}
