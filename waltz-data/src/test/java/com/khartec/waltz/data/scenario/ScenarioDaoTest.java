package com.khartec.waltz.data.scenario;

import com.khartec.waltz.model.EntityLifecycleStatus;
import com.khartec.waltz.model.ReleaseLifecycleStatus;
import com.khartec.waltz.model.scenario.ImmutableCloneScenarioCommand;
import com.khartec.waltz.model.scenario.ScenarioType;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ScenarioDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ScenarioDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ScenarioDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long roadmapId = 1L;
    String name = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.add(roadmapId, name, userId);
  }

  @Test
  public void cloneScenarioTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableCloneScenarioCommand command = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    scenarioDao.cloneScenario(command);
  }

  @Test
  public void findForRoadmapIdTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long roadmapId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.findForRoadmapId(roadmapId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.getById(id);
  }

  @Test
  public void removeScenarioTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.removeScenario(scenarioId, userId);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateDescription(scenarioId, newValue, userId);
  }

  @Test
  public void updateEffectiveDateTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    LocalDate newValue = null;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateEffectiveDate(scenarioId, newValue, userId);
  }

  @Test
  public void updateEntityLifecycleStatusTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    EntityLifecycleStatus newValue = EntityLifecycleStatus.ACTIVE;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateEntityLifecycleStatus(scenarioId, newValue, userId);
  }

  @Test
  public void updateNameTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateName(scenarioId, newValue, userId);
  }

  @Test
  public void updateReleaseStatusTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    ReleaseLifecycleStatus newValue = ReleaseLifecycleStatus.DRAFT;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateReleaseStatus(scenarioId, newValue, userId);
  }

  @Test
  public void updateScenarioTypeTest() throws Exception {
    // Arrange
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(new DefaultConfiguration()));
    long scenarioId = 1L;
    ScenarioType newValue = ScenarioType.TARGET;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    scenarioDao.updateScenarioType(scenarioId, newValue, userId);
  }
}
