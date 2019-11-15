package com.khartec.waltz.data.application;

import com.khartec.waltz.model.application.ImmutableAppRegistrationRequest;
import com.khartec.waltz.model.application.ImmutableApplication;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ApplicationDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ApplicationDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ApplicationDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void countByOrganisationalUnitTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.countByOrganisationalUnit();
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.findAll();
  }

  @Test
  public void findByAssetCodeTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    String externalId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.findByAssetCode(externalId);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.findByIds(arrayList);
  }

  @Test
  public void findRelatedByApplicationIdTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    long appId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.findRelatedByApplicationId(appId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    applicationDao.getById(id);
  }

  @Test
  public void registerAppTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableAppRegistrationRequest request = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    applicationDao.registerApp(request);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableApplication application = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    applicationDao.update(application);
  }
}
