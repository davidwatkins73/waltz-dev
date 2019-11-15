package com.khartec.waltz.data.measurable_rating;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand;
import com.khartec.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MeasurableRatingDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void MeasurableRatingDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new MeasurableRatingDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSaveMeasurableRatingCommand command = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableRatingDao.create(command);
  }

  @Test
  public void findByCategoryTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableRatingDao.findByCategory(id);
  }

  @Test
  public void findForEntityTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    measurableRatingDao.findForEntity(ref);
  }

  @Test
  public void removeForCategoryTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    long categoryId = 1L;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableRatingDao.removeForCategory(ref, categoryId);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableRemoveMeasurableRatingCommand command = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableRatingDao.remove(command);
  }

  @Test
  public void tallyByMeasurableCategoryIdTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long categoryId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    measurableRatingDao.tallyByMeasurableCategoryId(categoryId);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSaveMeasurableRatingCommand command = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    measurableRatingDao.update(command);
  }
}
