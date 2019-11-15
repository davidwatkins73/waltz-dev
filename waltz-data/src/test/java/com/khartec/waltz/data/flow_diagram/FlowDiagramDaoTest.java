package com.khartec.waltz.data.flow_diagram;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class FlowDiagramDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void FlowDiagramDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new FlowDiagramDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void cloneTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;
    String newName = "aaaaa";
    String userId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramDao.clone(diagramId, newName, userId);
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableFlowDiagram flowDiagram = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramDao.create(flowDiagram);
  }

  @Test
  public void deleteByIdTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramDao.deleteById(id);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramDao.findByEntityReference(ref);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramDao.getById(id);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String des = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramDao.updateDescription(id, des);
  }

  @Test
  public void updateNameTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;
    String name = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramDao.updateName(id, name);
  }

  @Test
  public void updateTest() throws Exception {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableFlowDiagram flowDiagram = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramDao.update(flowDiagram);
  }
}
