package com.khartec.waltz.data.complexity;

import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ConnectionComplexityDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ConnectionComplexityDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ConnectionComplexityDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void calculateBaselineTest() throws Exception {
    // Arrange
    ConnectionComplexityDao connectionComplexityDao = new ConnectionComplexityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    Long appIds = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    connectionComplexityDao.calculateBaseline(appIds);
  }

  @Test
  public void calculateBaselineTest2() throws Exception {
    // Arrange
    ConnectionComplexityDao connectionComplexityDao = new ConnectionComplexityDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    connectionComplexityDao.calculateBaseline();
  }

  @Test
  public void findCountsTest() throws Exception {
    // Arrange
    ConnectionComplexityDao connectionComplexityDao = new ConnectionComplexityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    Long resultLong = new Long(1L);
    Long[] appIds = new Long[]{resultLong, new Long(1L), resultLong};

    // Act and Assert
    thrown.expect(DetachedException.class);
    connectionComplexityDao.findCounts(appIds);
  }

  @Test
  public void findCountsTest2() throws Exception {
    // Arrange
    ConnectionComplexityDao connectionComplexityDao = new ConnectionComplexityDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    connectionComplexityDao.findCounts();
  }
}
