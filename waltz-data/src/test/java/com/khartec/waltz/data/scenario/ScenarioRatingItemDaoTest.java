package com.khartec.waltz.data.scenario;

import com.khartec.waltz.model.scenario.ImmutableCloneScenarioCommand;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ScenarioRatingItemDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ScenarioRatingItemDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ScenarioRatingItemDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addTest() throws Exception {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    long appId = 1L;
    long columnId = 1L;
    long rowId = 1L;
    char rating = 'c';
    String userId = "kaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioRatingItemDao.add(scenarioId, appId, columnId, rowId, rating, userId);
  }

  @Test
  public void cloneItemsTest() throws Exception {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableCloneScenarioCommand command = null;
    Long clonedScenarioId = new Long(1L);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    scenarioRatingItemDao.cloneItems(command, clonedScenarioId);
  }

  @Test
  public void findForScenarioIdTest() throws Exception {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioRatingItemDao.findForScenarioId(scenarioId);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    long appId = 1L;
    long columnId = 1L;
    long rowId = 1L;
    String userId = "akaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioRatingItemDao.remove(scenarioId, appId, columnId, rowId, userId);
  }

  @Test
  public void updateRatingTest() throws Exception {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    long appId = 1L;
    long columnId = 1L;
    long rowId = 1L;
    char rating = 'c';
    String comment = "kaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioRatingItemDao.updateRating(scenarioId, appId, columnId, rowId, rating, comment, userId);
  }
}
