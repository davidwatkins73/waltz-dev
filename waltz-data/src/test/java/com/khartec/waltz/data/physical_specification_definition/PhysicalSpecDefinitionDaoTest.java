package com.khartec.waltz.data.physical_specification_definition;

import com.khartec.waltz.model.ReleaseLifecycleStatus;
import com.khartec.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhysicalSpecDefinitionDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PhysicalSpecDefinitionDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PhysicalSpecDefinitionDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalSpecDefinition specDefinition = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalSpecDefinitionDao.create(specDefinition);
  }

  @Test
  public void deleteTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specDefinitionId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDefinitionDao.delete(specDefinitionId);
  }

  @Test
  public void findForSpecificationTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specificationId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDefinitionDao.findForSpecification(specificationId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specDefinitionId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDefinitionDao.getById(specDefinitionId);
  }

  @Test
  public void markExistingActiveAsDeprecatedTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specificationId = 1L;
    String userName = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDefinitionDao.markExistingActiveAsDeprecated(specificationId, userName);
  }

  @Test
  public void updateStatusTest() throws Exception {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specDefinitionId = 1L;
    ReleaseLifecycleStatus newStatus = ReleaseLifecycleStatus.DRAFT;
    String userName = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDefinitionDao.updateStatus(specDefinitionId, newStatus, userName);
  }
}
