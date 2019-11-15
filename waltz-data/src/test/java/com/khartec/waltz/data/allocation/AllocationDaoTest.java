package com.khartec.waltz.data.allocation;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.allocation.MeasurablePercentageChange;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AllocationDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void AllocationDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new AllocationDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void findByEntityAndSchemeTest() throws Exception {
    // Arrange
    AllocationDao allocationDao = new AllocationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    long schemeId = 1L;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    allocationDao.findByEntityAndScheme(ref, schemeId);
  }

  @Test
  public void findByEntityTest() throws Exception {
    // Arrange
    AllocationDao allocationDao = new AllocationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    allocationDao.findByEntity(ref);
  }

  @Test
  public void findByMeasurableIdAndSchemeTest() throws Exception {
    // Arrange
    AllocationDao allocationDao = new AllocationDao(new DefaultDSLContext(new DefaultConfiguration()));
    long measurableId = 1L;
    long schemeId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    allocationDao.findByMeasurableIdAndScheme(measurableId, schemeId);
  }

  @Test
  public void updateAllocationsTest() throws Exception {
    // Arrange
    AllocationDao allocationDao = new AllocationDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    long scheme = 1L;
    ArrayList<MeasurablePercentageChange> arrayList = new ArrayList<MeasurablePercentageChange>();
    arrayList.add(null);
    String username = "aaaak";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    allocationDao.updateAllocations(ref, scheme, arrayList, username);
  }
}
