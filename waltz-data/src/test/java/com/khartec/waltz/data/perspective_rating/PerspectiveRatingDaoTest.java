package com.khartec.waltz.data.perspective_rating;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.perspective.PerspectiveRatingValue;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class PerspectiveRatingDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PerspectiveRatingDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PerspectiveRatingDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addTest() throws Exception {
    // Arrange
    PerspectiveRatingDao perspectiveRatingDao = new PerspectiveRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    HashSet<PerspectiveRatingValue> hashSet = new HashSet<PerspectiveRatingValue>();
    hashSet.add(null);
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    perspectiveRatingDao.add(ref, hashSet, username);
  }

  @Test
  public void cascadeRemovalOfMeasurableRatingTest() throws Exception {
    // Arrange
    PerspectiveRatingDao perspectiveRatingDao = new PerspectiveRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference entityReference = null;
    long measurableId = 1L;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    perspectiveRatingDao.cascadeRemovalOfMeasurableRating(entityReference, measurableId);
  }

  @Test
  public void findForEntityTest() throws Exception {
    // Arrange
    PerspectiveRatingDao perspectiveRatingDao = new PerspectiveRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    perspectiveRatingDao.findForEntity(ref);
  }

  @Test
  public void findForEntityTest2() throws Exception {
    // Arrange
    PerspectiveRatingDao perspectiveRatingDao = new PerspectiveRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long categoryX = 1L;
    long categoryY = 1L;
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    perspectiveRatingDao.findForEntity(categoryX, categoryY, ref);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    PerspectiveRatingDao perspectiveRatingDao = new PerspectiveRatingDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;
    HashSet<PerspectiveRatingValue> hashSet = new HashSet<PerspectiveRatingValue>();
    hashSet.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    perspectiveRatingDao.remove(ref, hashSet);
  }
}
