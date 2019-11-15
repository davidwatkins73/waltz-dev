package com.khartec.waltz.data.roadmap;

import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RoadmapSearchDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void RoadmapSearchDaoTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act
    new RoadmapSearchDao(roadmapDao);
  }

  @Test
  public void searchTest() throws Exception {
    // Arrange
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(
        new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration())));
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    roadmapSearchDao.search(query, options);
  }
}
