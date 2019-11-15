package com.khartec.waltz.data.survey;

import com.khartec.waltz.model.survey.ImmutableSurveyQuestion;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SurveyQuestionDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void SurveyQuestionDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new SurveyQuestionDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSurveyQuestion surveyQuestion = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyQuestionDao.create(surveyQuestion);
  }

  @Test
  public void deleteTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    long questionId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyQuestionDao.delete(questionId);
  }

  @Test
  public void findForSurveyInstanceTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyInstanceId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyQuestionDao.findForSurveyInstance(surveyInstanceId);
  }

  @Test
  public void findForSurveyRunTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyQuestionDao.findForSurveyRun(surveyRunId);
  }

  @Test
  public void findForTemplateTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    long templateId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyQuestionDao.findForTemplate(templateId);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSurveyQuestion surveyQuestion = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyQuestionDao.update(surveyQuestion);
  }
}
