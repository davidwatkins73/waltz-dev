package com.khartec.waltz.data.logical_flow;

import com.khartec.waltz.model.EntityReference;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.logical_flow.ImmutableLogicalFlow;
import com.khartec.waltz.model.logical_flow.LogicalFlow;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LogicalFlowDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void LogicalFlowDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new LogicalFlowDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addFlowTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableLogicalFlow flow = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.addFlow(flow);
  }

  @Test
  public void addFlowsTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<LogicalFlow> arrayList = new ArrayList<LogicalFlow>();
    arrayList.add(null);
    String user = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.addFlows(arrayList, user);
  }

  @Test
  public void cleanupOrphansTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.cleanupOrphans();
  }

  @Test
  public void cleanupSelfReferencingFlowsTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.cleanupSelfReferencingFlows();
  }

  @Test
  public void findActiveByFlowIdsTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.findActiveByFlowIds(arrayList);
  }

  @Test
  public void findAllActiveTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.findAllActive();
  }

  @Test
  public void findAllByFlowIdsTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.findAllByFlowIds(arrayList);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.findByEntityReference(ref);
  }

  @Test
  public void findBySourcesAndTargetsTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Tuple2<EntityReference, EntityReference>> arrayList = new ArrayList<Tuple2<EntityReference, EntityReference>>();
    arrayList.add(new Tuple2<EntityReference, EntityReference>(null, null));

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.findBySourcesAndTargets(arrayList);
  }

  @Test
  public void findUpstreamFlowsForEntityReferencesTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<EntityReference> arrayList = new ArrayList<EntityReference>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.findUpstreamFlowsForEntityReferences(arrayList);
  }

  @Test
  public void getByFlowIdTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long dataFlowId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.getByFlowId(dataFlowId);
  }

  @Test
  public void getBySourceAndTargetTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference source = null;
    ImmutableEntityReference target = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDao.getBySourceAndTarget(source, target);
  }

  @Test
  public void removeFlowTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    Long flowId = new Long(1L);
    String user = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.removeFlow(flowId, user);
  }

  @Test
  public void restoreFlowTest() throws Exception {
    // Arrange
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long logicalFlowId = 1L;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDao.restoreFlow(logicalFlowId, username);
  }
}
