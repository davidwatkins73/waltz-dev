package com.khartec.waltz.data.flow_diagram;

import com.khartec.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlowDiagramAnnotationDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void FlowDiagramAnnotationDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new FlowDiagramAnnotationDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void cloneTest() throws Exception {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;
    Long clonedDiagramId = new Long(1L);

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramAnnotationDao.clone(diagramId, clonedDiagramId);
  }

  @Test
  public void createAnnotationsTest() throws Exception {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<FlowDiagramAnnotation> arrayList = new ArrayList<FlowDiagramAnnotation>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    flowDiagramAnnotationDao.createAnnotations(arrayList);
  }

  @Test
  public void deleteForDiagramTest() throws Exception {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramAnnotationDao.deleteForDiagram(diagramId);
  }

  @Test
  public void findByDiagramIdTest() throws Exception {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long diagramId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    flowDiagramAnnotationDao.findByDiagramId(diagramId);
  }
}
