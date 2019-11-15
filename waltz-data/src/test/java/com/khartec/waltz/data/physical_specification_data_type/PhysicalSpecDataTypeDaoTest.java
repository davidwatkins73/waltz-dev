package com.khartec.waltz.data.physical_specification_data_type;

import com.khartec.waltz.model.physical_specification_data_type.PhysicalSpecificationDataType;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PhysicalSpecDataTypeDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PhysicalSpecDataTypeDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PhysicalSpecDataTypeDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addDataTypesTest() throws Exception {
    // Arrange
    PhysicalSpecDataTypeDao physicalSpecDataTypeDao = new PhysicalSpecDataTypeDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<PhysicalSpecificationDataType> arrayList = new ArrayList<PhysicalSpecificationDataType>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalSpecDataTypeDao.addDataTypes(arrayList);
  }

  @Test
  public void findBySpecificationIdTest() throws Exception {
    // Arrange
    PhysicalSpecDataTypeDao physicalSpecDataTypeDao = new PhysicalSpecDataTypeDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDataTypeDao.findBySpecificationId(specId);
  }

  @Test
  public void getBySpecIdAndDataTypeIDTest() throws Exception {
    // Arrange
    PhysicalSpecDataTypeDao physicalSpecDataTypeDao = new PhysicalSpecDataTypeDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long specId = 1L;
    long dataTypeId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDataTypeDao.getBySpecIdAndDataTypeID(specId, dataTypeId);
  }

  @Test
  public void removeDataTypesTest() throws Exception {
    // Arrange
    PhysicalSpecDataTypeDao physicalSpecDataTypeDao = new PhysicalSpecDataTypeDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<PhysicalSpecificationDataType> arrayList = new ArrayList<PhysicalSpecificationDataType>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalSpecDataTypeDao.removeDataTypes(arrayList);
  }

  @Test
  public void rippleDataTypesToLogicalFlowsTest() throws Exception {
    // Arrange
    PhysicalSpecDataTypeDao physicalSpecDataTypeDao = new PhysicalSpecDataTypeDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalSpecDataTypeDao.rippleDataTypesToLogicalFlows();
  }
}
