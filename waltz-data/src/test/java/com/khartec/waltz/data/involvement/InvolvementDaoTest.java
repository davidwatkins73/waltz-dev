package com.khartec.waltz.data.involvement;

import com.khartec.waltz.data.ImmutableGenericSelector;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.involvement.ImmutableInvolvement;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class InvolvementDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void InvolvementDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new InvolvementDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void deleteByGenericEntitySelectorTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector genericSelector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.deleteByGenericEntitySelector(genericSelector);
  }

  @Test
  public void findAllApplicationsByEmployeeIdTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementDao.findAllApplicationsByEmployeeId(employeeId);
  }

  @Test
  public void findByEmployeeIdTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementDao.findByEmployeeId(employeeId);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.findByEntityReference(ref);
  }

  @Test
  public void findByGenericEntitySelectorTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector genericSelector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.findByGenericEntitySelector(genericSelector);
  }

  @Test
  public void findDirectApplicationsByEmployeeIdTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementDao.findDirectApplicationsByEmployeeId(employeeId);
  }

  @Test
  public void findPeopleByEntityReferenceTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.findPeopleByEntityReference(ref);
  }

  @Test
  public void findPeopleByGenericEntitySelectorTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector selector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.findPeopleByGenericEntitySelector(selector);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableInvolvement involvement = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.remove(involvement);
  }

  @Test
  public void saveTest() throws Exception {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableInvolvement involvement = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    involvementDao.save(involvement);
  }
}
