package com.khartec.waltz.data.person;

import com.khartec.waltz.model.person.ImmutablePerson;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class PersonDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PersonDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PersonDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void allTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.all();
  }

  @Test
  public void bulkSaveTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<ImmutablePerson> arrayList = new ArrayList<ImmutablePerson>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    personDao.bulkSave(arrayList);
  }

  @Test
  public void countAllUnderlingsByKindTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.countAllUnderlingsByKind(employeeId);
  }

  @Test
  public void findAllManagersByEmployeeIdTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.findAllManagersByEmployeeId(employeeId);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    HashSet<Long> hashSet = new HashSet<Long>();
    hashSet.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.findByIds(hashSet);
  }

  @Test
  public void findDirectsByEmployeeIdTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.findDirectsByEmployeeId(employeeId);
  }

  @Test
  public void findPersonsByAttestationInstanceIdTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    long instanceId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.findPersonsByAttestationInstanceId(instanceId);
  }

  @Test
  public void getActiveByUserEmailTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String email = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.getActiveByUserEmail(email);
  }

  @Test
  public void getByEmployeeIdTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String employeeId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.getByEmployeeId(employeeId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.getById(id);
  }

  @Test
  public void getByUserEmailTest() throws Exception {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(new DefaultConfiguration()));
    String email = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    personDao.getByUserEmail(email);
  }
}
