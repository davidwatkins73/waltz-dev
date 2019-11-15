package com.khartec.waltz.data.survey;

import com.khartec.waltz.model.survey.ImmutableSurveyRunChangeCommand;
import com.khartec.waltz.model.survey.ImmutableSurveyRunCreateCommand;
import com.khartec.waltz.model.survey.SurveyRunStatus;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class SurveyRunDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void SurveyRunDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new SurveyRunDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long ownerId = 1L;
    ImmutableSurveyRunCreateCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyRunDao.create(ownerId, command);
  }

  @Test
  public void findByTemplateIdTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long templateId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.findByTemplateId(templateId);
  }

  @Test
  public void findForRecipientTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long personId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.findForRecipient(personId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.getById(id);
  }

  @Test
  public void issueTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.issue(surveyRunId);
  }

  @Test
  public void updateDueDateTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;
    LocalDate newDueDate = null;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.updateDueDate(surveyRunId, newDueDate);
  }

  @Test
  public void updateStatusTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;
    SurveyRunStatus newStatus = SurveyRunStatus.DRAFT;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyRunDao.updateStatus(surveyRunId, newStatus);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    SurveyRunDao surveyRunDao = new SurveyRunDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;
    ImmutableSurveyRunChangeCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyRunDao.update(surveyRunId, command);
  }
}
