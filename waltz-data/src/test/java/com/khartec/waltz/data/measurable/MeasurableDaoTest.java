package com.khartec.waltz.data.measurable;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.measurable.ImmutableMeasurable;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MeasurableDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void MeasurableDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new MeasurableDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableMeasurable measurable = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableDao.create(measurable);
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.findAll();
  }

  @Test
  public void findByCategoryIdTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long categoryId = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.findByCategoryId(categoryId);
  }

  @Test
  public void findByExternalIdTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    String extId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.findByExternalId(extId);
  }

  @Test
  public void findMeasuresRelatedToEntityTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    measurableDao.findMeasuresRelatedToEntity(ref);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.getById(id);
  }

  @Test
  public void updateConcreteFlagTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long id = new Long(1L);
    boolean newValue = true;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.updateConcreteFlag(id, newValue, userId);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.updateDescription(id, newValue, userId);
  }

  @Test
  public void updateExternalIdTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.updateExternalId(id, newValue, userId);
  }

  @Test
  public void updateNameTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String newValue = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.updateName(id, newValue, userId);
  }

  @Test
  public void updateParentIdTest() throws Exception {
    // Arrange
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long measurableId = new Long(1L);
    Long destinationId = new Long(1L);
    String userId = "akaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableDao.updateParentId(measurableId, destinationId, userId);
  }
}
