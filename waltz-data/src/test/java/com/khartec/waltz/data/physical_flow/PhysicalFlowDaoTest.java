package com.khartec.waltz.data.physical_flow;

import com.khartec.waltz.model.Criticality;
import com.khartec.waltz.model.EntityLifecycleStatus;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.physical_flow.FrequencyKind;
import com.khartec.waltz.model.physical_flow.ImmutablePhysicalFlow;
import com.khartec.waltz.model.physical_flow.ImmutablePhysicalFlowParsed;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhysicalFlowDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PhysicalFlowDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PhysicalFlowDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void cleanupOrphansTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.cleanupOrphans();
  }

  @Test
  public void createTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalFlow flow = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalFlowDao.create(flow);
  }

  @Test
  public void deleteTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.delete(flowId);
  }

  @Test
  public void findByAttributesAndSpecificationTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalFlow flow = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.findByAttributesAndSpecification(flow);
  }

  @Test
  public void findByConsumerTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.findByConsumer(ref);
  }

  @Test
  public void findByEntityReferenceTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    physicalFlowDao.findByEntityReference(ref);
  }

  @Test
  public void findByExternalIdTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    String externalId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.findByExternalId(externalId);
  }

  @Test
  public void findByProducerAndConsumerTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference producer = null;
    ImmutableEntityReference consumer = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.findByProducerAndConsumer(producer, consumer);
  }

  @Test
  public void findByProducerTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference ref = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.findByProducer(ref);
  }

  @Test
  public void findBySpecificationIdTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long specificationId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.findBySpecificationId(specificationId);
  }

  @Test
  public void getByIdTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.getById(id);
  }

  @Test
  public void getByParsedFlowTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalFlowParsed flow = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.getByParsedFlow(flow);
  }

  @Test
  public void hasPhysicalFlowsTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long logicalFlowId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.hasPhysicalFlows(logicalFlowId);
  }

  @Test
  public void matchPhysicalFlowTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    ImmutablePhysicalFlow flow = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowDao.matchPhysicalFlow(flow);
  }

  @Test
  public void updateBasisOffsetTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    int basis = 1;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateBasisOffset(flowId, basis);
  }

  @Test
  public void updateCriticalityTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    Criticality criticality = Criticality.LOW;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateCriticality(flowId, criticality);
  }

  @Test
  public void updateDescriptionTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    String description = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateDescription(flowId, description);
  }

  @Test
  public void updateEntityLifecycleStatusTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    EntityLifecycleStatus entityLifecycleStatus = EntityLifecycleStatus.ACTIVE;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateEntityLifecycleStatus(flowId, entityLifecycleStatus);
  }

  @Test
  public void updateExternalIdTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    String externalId = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateExternalId(flowId, externalId);
  }

  @Test
  public void updateFrequencyTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    FrequencyKind frequencyKind = FrequencyKind.ON_DEMAND;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateFrequency(flowId, frequencyKind);
  }

  @Test
  public void updateSpecDefinitionTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    String userName = "aaaaa";
    long flowId = 1L;
    long newSpecDefinitionId = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateSpecDefinition(userName, flowId, newSpecDefinitionId);
  }

  @Test
  public void updateTransportTest() throws Exception {
    // Arrange
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    String transport = "aaaaa";

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowDao.updateTransport(flowId, transport);
  }
}
