package com.khartec.waltz.data.taxonomy_management;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand;
import com.khartec.waltz.model.taxonomy_management.TaxonomyChangeLifecycleStatus;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TaxonomyChangeDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void TaxonomyChangeDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new TaxonomyChangeDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void createCommandTest() throws Exception {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableTaxonomyChangeCommand cmd = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    taxonomyChangeDao.createCommand(cmd);
  }

  @Test
  public void findChangesByDomainAndStatusTest() throws Exception {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference domain = null;
    TaxonomyChangeLifecycleStatus status = TaxonomyChangeLifecycleStatus.DRAFT;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    taxonomyChangeDao.findChangesByDomainAndStatus(domain, status);
  }

  @Test
  public void getDraftCommandByIdTest() throws Exception {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    taxonomyChangeDao.getDraftCommandById(id);
  }

  @Test
  public void removeByIdTest() throws Exception {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    taxonomyChangeDao.removeById(id, userId);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableTaxonomyChangeCommand cmd = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    taxonomyChangeDao.update(cmd);
  }
}
