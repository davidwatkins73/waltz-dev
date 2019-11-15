package com.khartec.waltz.data.roadmap;

import com.khartec.waltz.model.EntityLifecycleStatus;
import com.khartec.waltz.model.ImmutableEntityReference;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RoadmapDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void RoadmapDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new RoadmapDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createRoadmapTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    String name = "aaaaa";
    long ratingSchemeId = 1L;
    ImmutableEntityReference columnType = null;
    ImmutableEntityReference rowType = null;
    String userId = "kaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    roadmapDao.createRoadmap(name, ratingSchemeId, columnType, rowType, userId);
  }

  @Test
  public void findAllActiveTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.findAllActive();
  }

  @Test
  public void findAllRoadmapsAndScenariosTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.findAllRoadmapsAndScenarios();
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.findAll();
  }

  @Test
  public void findRoadmapsAndScenariosByFormalRelationshipTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference relatedEntity = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    roadmapDao.findRoadmapsAndScenariosByFormalRelationship(relatedEntity);
  }

  @Test
  public void findRoadmapsAndScenariosByRatedEntityTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ratedEntity = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    roadmapDao.findRoadmapsAndScenariosByRatedEntity(ratedEntity);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.getById(id);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.updateDescription(id, newValue, userId);
  }

  @Test
  public void updateLifecycleStatusTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    EntityLifecycleStatus newValue = EntityLifecycleStatus.ACTIVE;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.updateLifecycleStatus(id, newValue, userId);
  }

  @Test
  public void updateNameTest() throws Exception {
    // Arrange
    RoadmapDao roadmapDao = new RoadmapDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    roadmapDao.updateName(id, newValue, userId);
  }
}
