package com.khartec.waltz.data.assessment_rating;

import com.khartec.waltz.data.ImmutableGenericSelector;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.assessment_rating.ImmutableRemoveAssessmentRatingCommand;
import com.khartec.waltz.model.assessment_rating.ImmutableSaveAssessmentRatingCommand;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AssessmentRatingDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void AssessmentRatingDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new AssessmentRatingDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSaveAssessmentRatingCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    assessmentRatingDao.create(command);
  }

  @Test
  public void findByGenericSelectorTest() throws Exception {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector genericSelector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    assessmentRatingDao.findByGenericSelector(genericSelector);
  }

  @Test
  public void findForEntityTest() throws Exception {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    assessmentRatingDao.findForEntity(ref);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableRemoveAssessmentRatingCommand rating = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    assessmentRatingDao.remove(rating);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSaveAssessmentRatingCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    assessmentRatingDao.update(command);
  }
}
