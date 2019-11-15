package com.khartec.waltz.data.tag;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.ImmutableEntityReference;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TagDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void TagDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new TagDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createTagTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind targetKind = EntityKind.ACTOR;
    String tag = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    tagDao.createTag(targetKind, tag);
  }

  @Test
  public void createTagUsageTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    String username = "aaaaa";
    Long tagId = new Long(1L);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    tagDao.createTagUsage(ref, username, tagId);
  }

  @Test
  public void findAllTagsTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    tagDao.findAllTags();
  }

  @Test
  public void findByTagTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    String tag = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    tagDao.findByTag(tag);
  }

  @Test
  public void findTagByNameAndTargetKindTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind entityKind = EntityKind.ACTOR;
    String tagName = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    tagDao.findTagByNameAndTargetKind(entityKind, tagName);
  }

  @Test
  public void findTagsForEntityKindTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    EntityKind entityKind = EntityKind.ACTOR;

    // Act and Assert
    thrown.expect(DetachedException.class);
    tagDao.findTagsForEntityKind(entityKind);
  }

  @Test
  public void findTagsForEntityReferenceTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    tagDao.findTagsForEntityReference(ref);
  }

  @Test
  public void removeTagUsageTest() throws Exception {
    // Arrange
    TagDao tagDao = new TagDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    String tagToRemove = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    tagDao.removeTagUsage(ref, tagToRemove);
  }
}
