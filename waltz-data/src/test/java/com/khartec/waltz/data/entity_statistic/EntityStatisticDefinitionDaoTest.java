package com.khartec.waltz.data.entity_statistic;

import com.khartec.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EntityStatisticDefinitionDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void EntityStatisticDefinitionDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new EntityStatisticDefinitionDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void findAllActiveDefinitionsTest() throws Exception {
    // Arrange
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    boolean rollupOnly = true;

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityStatisticDefinitionDao.findAllActiveDefinitions(rollupOnly);
  }

  @Test
  public void findByIdsTest() throws Exception {
    // Arrange
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityStatisticDefinitionDao.findByIds(arrayList);
  }

  @Test
  public void findRelatedTest() throws Exception {
    // Arrange
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    boolean rollupOnly = true;

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityStatisticDefinitionDao.findRelated(id, rollupOnly);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    entityStatisticDefinitionDao.getById(id);
  }

  @Test
  public void insertTest() throws Exception {
    // Arrange
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityStatisticDefinition entityStatistic = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    entityStatisticDefinitionDao.insert(entityStatistic);
  }
}
