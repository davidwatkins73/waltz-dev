package com.khartec.waltz.data.flow_diagram;

import com.khartec.waltz.data.ImmutableGenericSelector;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.flow_diagram.FlowDiagramEntity;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlowDiagramEntityDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void FlowDiagramEntityDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new FlowDiagramEntityDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void cloneTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;
    Long clonedDiagramId = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramEntityDao.clone(diagramId, clonedDiagramId);
  }

  @Test
  public void createEntitiesTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<FlowDiagramEntity> arrayList = new ArrayList<FlowDiagramEntity>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramEntityDao.createEntities(arrayList);
  }

  @Test
  public void deleteEntityForDiagramTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;
    ImmutableEntityReference entityReference = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramEntityDao.deleteEntityForDiagram(diagramId, entityReference);
  }

  @Test
  public void deleteForDiagramTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramEntityDao.deleteForDiagram(diagramId);
  }

  @Test
  public void deleteForGenericEntitySelectorTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableGenericSelector selector = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramEntityDao.deleteForGenericEntitySelector(selector);
  }

  @Test
  public void findForDiagramTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramEntityDao.findForDiagram(diagramId);
  }

  @Test
  public void findForEntityTest() throws Exception {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramEntityDao.findForEntity(ref);
  }
}
