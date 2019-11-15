package com.khartec.waltz.data.survey;

import com.khartec.waltz.model.survey.ImmutableSurveyInstance;
import com.khartec.waltz.model.survey.ImmutableSurveyInstanceCreateCommand;
import com.khartec.waltz.model.survey.SurveyInstanceStatus;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SurveyInstanceDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void SurveyInstanceDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new SurveyInstanceDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void clearApprovedTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.clearApproved(instanceId);
  }

  @Test
  public void createInstanceRecipientsTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long instanceId = new Long(1L);
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(NullPointerException.class);
    surveyInstanceDao.createInstanceRecipients(instanceId, arrayList);
  }

  @Test
  public void createPreviousVersionTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSurveyInstance currentInstance = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyInstanceDao.createPreviousVersion(currentInstance);
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableSurveyInstanceCreateCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    surveyInstanceDao.create(command);
  }

  @Test
  public void deleteForSurveyRunTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.deleteForSurveyRun(surveyRunId);
  }

  @Test
  public void findCompletionRateForSurveyTemplateTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long surveyTemplateId = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.findCompletionRateForSurveyTemplate(surveyTemplateId);
  }

  @Test
  public void findForRecipientTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long personId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.findForRecipient(personId);
  }

  @Test
  public void findForSurveyRunTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.findForSurveyRun(surveyRunId);
  }

  @Test
  public void findPreviousVersionsForInstanceTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.findPreviousVersionsForInstance(instanceId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.getById(id);
  }

  @Test
  public void getCompletionRateForSurveyRunTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long surveyRunId = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.getCompletionRateForSurveyRun(surveyRunId);
  }

  @Test
  public void markApprovedTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;
    String userName = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.markApproved(instanceId, userName);
  }

  @Test
  public void updateDueDateForSurveyRunTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long surveyRunId = 1L;
    LocalDate newDueDate = null;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.updateDueDateForSurveyRun(surveyRunId, newDueDate);
  }

  @Test
  public void updateDueDateTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;
    LocalDate newDueDate = null;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.updateDueDate(instanceId, newDueDate);
  }

  @Test
  public void updateStatusTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;
    SurveyInstanceStatus newStatus = SurveyInstanceStatus.NOT_STARTED;

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.updateStatus(instanceId, newStatus);
  }

  @Test
  public void updateSubmittedTest() throws Exception {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = new SurveyInstanceDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;
    String userName = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    surveyInstanceDao.updateSubmitted(instanceId, userName);
  }
}
