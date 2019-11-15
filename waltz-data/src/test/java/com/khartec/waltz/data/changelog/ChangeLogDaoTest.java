package com.khartec.waltz.data.changelog;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.changelog.ChangeLog;
import com.khartec.waltz.model.changelog.ImmutableChangeLog;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Optional;

public class ChangeLogDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ChangeLogDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ChangeLogDao(dsl);
  }

  @Test
  public void findByParentReferenceTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    Optional<Integer> limit = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    changeLogDao.findByParentReference(ref, limit);
  }

  @Test
  public void findByPersonReferenceTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    Optional<Integer> limit = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    changeLogDao.findByPersonReference(ref, limit);
  }

  @Test
  public void findByUserTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    String userName = "aaaaa";
    Optional<Integer> limit = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    changeLogDao.findByUser(userName, limit);
  }

  @Test
  public void getContributionLeaderBoardLastMonthTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    int limit = 1;

    // Act and Assert
    thrown.expect(DetachedException.class);
    changeLogDao.getContributionLeaderBoardLastMonth(limit);
  }

  @Test
  public void getContributionLeaderBoardTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    int limit = 1;

    // Act and Assert
    thrown.expect(DetachedException.class);
    changeLogDao.getContributionLeaderBoard(limit);
  }

  @Test
  public void getContributionScoresForUsersTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("aaaaa");

    // Act and Assert
    thrown.expect(DetachedException.class);
    changeLogDao.getContributionScoresForUsers(arrayList);
  }

  @Test
  public void getRankingOfContributorsTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    changeLogDao.getRankingOfContributors();
  }

  @Test
  public void writeTest() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<ChangeLog> arrayList = new ArrayList<ChangeLog>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    changeLogDao.write(arrayList);
  }

  @Test
  public void writeTest2() throws Exception {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableChangeLog changeLog = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    changeLogDao.write(changeLog);
  }
}
