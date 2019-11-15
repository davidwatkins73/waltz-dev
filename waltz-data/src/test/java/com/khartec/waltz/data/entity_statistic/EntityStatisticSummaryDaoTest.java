package com.khartec.waltz.data.entity_statistic;

import com.khartec.waltz.data.DBExecutorPool;
import com.khartec.waltz.model.Duration;
import com.khartec.waltz.model.ImmutableEntityReference;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EntityStatisticSummaryDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void EntityStatisticSummaryDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());
    DBExecutorPool dbExecutorPool = new DBExecutorPool(1, 1);

    // Act
    new EntityStatisticSummaryDao(defaultDSLContext, dbExecutorPool);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void generateHistoricWithNoRollupTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(defaultDSLContext,
        new DBExecutorPool(1, 1));
    Long statisticId = new Long(167772161L);
    ImmutableEntityReference entityReference = null;
    Duration duration = Duration.DAY;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityStatisticSummaryDao.generateHistoricWithNoRollup(statisticId, entityReference, duration);
  }

  @Test
  public void generateWithNoRollupTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(defaultDSLContext,
        new DBExecutorPool(1, 1));
    Long statisticId = new Long(167772161L);
    ImmutableEntityReference entityReference = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    entityStatisticSummaryDao.generateWithNoRollup(statisticId, entityReference);
  }

  @Test
  public void generateWithNoRollupTest2() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(defaultDSLContext,
        new DBExecutorPool(1, 1));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(11L));
    ImmutableEntityReference entityReference = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityStatisticSummaryDao.generateWithNoRollup(arrayList, entityReference);
  }
}
