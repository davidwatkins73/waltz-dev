package com.khartec.waltz.data.involvement_kind;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.involvement_kind.ImmutableInvolvementKindChangeCommand;
import com.khartec.waltz.model.involvement_kind.ImmutableInvolvementKindCreateCommand;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class InvolvementKindDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void InvolvementKindDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new InvolvementKindDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableInvolvementKindCreateCommand command = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    involvementKindDao.create(command, username);
  }

  @Test
  public void deleteIfNotUsedTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementKindDao.deleteIfNotUsed(id);
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementKindDao.findAll();
  }

  @Test
  public void findKeyInvolvementKindsByEntityKindTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind kind = EntityKind.ACTOR;

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementKindDao.findKeyInvolvementKindsByEntityKind(kind);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    involvementKindDao.getById(id);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableInvolvementKindChangeCommand command = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    involvementKindDao.update(command);
  }
}
