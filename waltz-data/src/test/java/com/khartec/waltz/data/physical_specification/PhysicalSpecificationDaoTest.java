package com.khartec.waltz.data.physical_specification;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.physical_flow.ImmutablePhysicalFlowParsed;
import com.khartec.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PhysicalSpecificationDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PhysicalSpecificationDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PhysicalSpecificationDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalSpecification specification = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalSpecificationDao.create(specification);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalSpecificationDao.findByEntityReference(ref);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecificationDao.findByIds(arrayList);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecificationDao.getById(id);
  }

  @Test
  public void getByParsedFlowTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalFlowParsed flow = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalSpecificationDao.getByParsedFlow(flow);
  }

  @Test
  public void isUsedTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecificationDao.isUsed(id);
  }

  @Test
  public void markRemovedIfUnusedTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecificationDao.markRemovedIfUnused(specId);
  }

  @Test
  public void updateExternalIdTest() throws Exception {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specificationId = 1L;
    String externalId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecificationDao.updateExternalId(specificationId, externalId);
  }
}
