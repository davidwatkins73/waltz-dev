package com.khartec.waltz.data.server_information;

import com.khartec.waltz.model.server_information.ServerInformation;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ServerInformationDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ServerInformationDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ServerInformationDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void bulkSaveTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<ServerInformation> arrayList = new ArrayList<ServerInformation>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    serverInformationDao.bulkSave(arrayList);
  }

  @Test
  public void findByAppIdTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long appId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    serverInformationDao.findByAppId(appId);
  }

  @Test
  public void findByAssetCodeTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    String assetCode = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    serverInformationDao.findByAssetCode(assetCode);
  }

  @Test
  public void getByExternalIdTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    String externalId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    serverInformationDao.getByExternalId(externalId);
  }

  @Test
  public void getByHostnameTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    String hostname = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    serverInformationDao.getByHostname(hostname);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    serverInformationDao.getById(id);
  }
}
