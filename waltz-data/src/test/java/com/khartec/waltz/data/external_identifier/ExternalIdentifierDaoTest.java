package com.khartec.waltz.data.external_identifier;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.external_identifier.ExternalIdentifier;
import com.khartec.waltz.model.external_identifier.ImmutableExternalIdentifier;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ExternalIdentifierDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void ExternalIdentifierDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new ExternalIdentifierDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    HashSet<ExternalIdentifier> hashSet = new HashSet<ExternalIdentifier>();
    hashSet.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.create(hashSet);
  }

  @Test
  public void createTest2() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableExternalIdentifier externalIdentifier = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.create(externalIdentifier);
  }

  @Test
  public void deleteTest() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference entityRef = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.delete(entityRef);
  }

  @Test
  public void deleteTest2() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableExternalIdentifier externalIdentifier = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.delete(externalIdentifier);
  }

  @Test
  public void deleteTest3() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<ExternalIdentifier> arrayList = new ArrayList<ExternalIdentifier>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.delete(arrayList);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference entityRef = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    externalIdentifierDao.findByEntityReference(entityRef);
  }

  @Test
  public void findByKindTest() throws Exception {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind kind = EntityKind.ACTOR;
    String extId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    externalIdentifierDao.findByKind(kind, extId);
  }
}
