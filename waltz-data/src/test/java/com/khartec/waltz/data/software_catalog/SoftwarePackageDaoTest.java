package com.khartec.waltz.data.software_catalog;

import com.khartec.waltz.model.software_catalog.SoftwarePackage;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SoftwarePackageDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void SoftwarePackageDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new SoftwarePackageDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void bulkStoreTest() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<SoftwarePackage> arrayList = new ArrayList<SoftwarePackage>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    softwarePackageDao.bulkStore(arrayList);
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    softwarePackageDao.findAll();
  }

  @Test
  public void findByExternalIdsTest() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));
    String[] externalIds = new String[]{"aaaaa", "aaaaa", "kaaaa"};

    // Act and Assert
    thrown.expect(DetachedException.class);
    softwarePackageDao.findByExternalIds(externalIds);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long resultLong = new Long(1L);
    Long[] ids = new Long[]{resultLong, new Long(1L), resultLong};

    // Act and Assert
    thrown.expect(DetachedException.class);
    softwarePackageDao.findByIds(ids);
  }

  @Test
  public void findByIdsTest2() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    softwarePackageDao.findByIds(arrayList);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    softwarePackageDao.getById(id);
  }
}
