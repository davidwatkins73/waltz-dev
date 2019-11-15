package com.khartec.waltz.data.entity_relationship;

import com.khartec.waltz.data.ImmutableGenericSelector;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.entity_relationship.ImmutableEntityRelationship;
import com.khartec.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import com.khartec.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class EntityRelationshipDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void EntityRelationshipDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new EntityRelationshipDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityRelationship relationship = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityRelationshipDao.create(relationship);
  }

  @Test
  public void deleteForGenericEntitySelectorTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector selector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityRelationshipDao.deleteForGenericEntitySelector(selector);
  }

  @Test
  public void findForGenericEntitySelectorTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector selector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityRelationshipDao.findForGenericEntitySelector(selector);
  }

  @Test
  public void findRelationshipsInvolvingTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityRelationshipDao.findRelationshipsInvolving(ref);
  }

  @Test
  public void removeAnyInvolvingTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference entityReference = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityRelationshipDao.removeAnyInvolving(entityReference);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityRelationship entityRelationship = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityRelationshipDao.remove(entityRelationship);
  }

  @Test
  public void removeTest2() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityRelationshipKey key = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityRelationshipDao.remove(key);
  }

  @Test
  public void saveTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityRelationship entityRelationship = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityRelationshipDao.save(entityRelationship);
  }

  @Test
  public void tallyRelationshipsInvolvingTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityRelationshipDao.tallyRelationshipsInvolving(ref);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityRelationshipKey key = null;
    ImmutableUpdateEntityRelationshipParams params = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityRelationshipDao.update(key, params, username);
  }
}
