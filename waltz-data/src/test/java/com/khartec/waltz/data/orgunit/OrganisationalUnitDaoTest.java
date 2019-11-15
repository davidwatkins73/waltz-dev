package com.khartec.waltz.data.orgunit;

import com.khartec.waltz.model.ImmutableEntityReference;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class OrganisationalUnitDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void OrganisationalUnitDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(dsl);

    // Assert
    assertEquals(
        "OrganisationalUnitDao{dsl=DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]}",
        organisationalUnitDao.toString());
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.findAll();
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    Long resultLong = new Long(1L);
    Long[] ids = new Long[]{resultLong, new Long(1L), resultLong};

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.findByIds(ids);
  }

  @Test
  public void findDescendantsTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.findDescendants(id);
  }

  @Test
  public void findImmediateHierarchyTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.findImmediateHierarchy(id);
  }

  @Test
  public void findRelatedByEntityRefTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    organisationalUnitDao.findRelatedByEntityRef(ref);
  }

  @Test
  public void getByAppIdTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.getByAppId(id);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.getById(id);
  }

  @Test
  public void toStringTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act
    String actual = organisationalUnitDao.toString();

    // Assert
    assertEquals(
        "OrganisationalUnitDao{dsl=DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]}",
        actual);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String description = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    organisationalUnitDao.updateDescription(id, description);
  }
}
