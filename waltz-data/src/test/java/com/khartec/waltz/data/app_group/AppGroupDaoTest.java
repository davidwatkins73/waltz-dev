package com.khartec.waltz.data.app_group;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.app_group.ImmutableAppGroup;
import com.khartec.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AppGroupDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void AppGroupDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new AppGroupDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void deleteGroupTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    long groupId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.deleteGroup(groupId);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    String user = "aaaaa";
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.findByIds(user, arrayList);
  }

  @Test
  public void findGroupsForUserTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.findGroupsForUser(userId);
  }

  @Test
  public void findPrivateGroupsByOwnerTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.findPrivateGroupsByOwner(userId);
  }

  @Test
  public void findPublicGroupsTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.findPublicGroups();
  }

  @Test
  public void findRelatedByApplicationIdTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    long appId = 1L;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.findRelatedByApplicationId(appId, username);
  }

  @Test
  public void findRelatedByEntityReferenceTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    appGroupDao.findRelatedByEntityReference(ref, username);
  }

  @Test
  public void getGroupTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    long groupId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    appGroupDao.getGroup(groupId);
  }

  @Test
  public void insertTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableAppGroup appGroup = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    appGroupDao.insert(appGroup);
  }

  @Test
  public void searchTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    String query = "aaaaa";
    ImmutableEntitySearchOptions options = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    appGroupDao.search(query, options);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableAppGroup appGroup = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    appGroupDao.update(appGroup);
  }
}
