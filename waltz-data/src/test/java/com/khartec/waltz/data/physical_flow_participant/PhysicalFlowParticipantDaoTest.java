package com.khartec.waltz.data.physical_flow_participant;

import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.physical_flow_participant.ParticipationKind;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PhysicalFlowParticipantDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void PhysicalFlowParticipantDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new PhysicalFlowParticipantDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addTest() throws Exception {
    // Arrange
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long physicalFlowId = 1L;
    ParticipationKind participationKind = ParticipationKind.SOURCE;
    ImmutableEntityReference participant = null;
    String username = "aaaaa";

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowParticipantDao.add(physicalFlowId, participationKind, participant, username);
  }

  @Test
  public void findByParticipantTest() throws Exception {
    // Arrange
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ImmutableEntityReference entityReference = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowParticipantDao.findByParticipant(entityReference);
  }

  @Test
  public void findByPhysicalFlowIdTest() throws Exception {
    // Arrange
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long id = 1L;

    // Act and Assert
    thrown.expect(DetachedException.class);
    physicalFlowParticipantDao.findByPhysicalFlowId(id);
  }

  @Test
  public void removeTest() throws Exception {
    // Arrange
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long physicalFlowId = 1L;
    ParticipationKind participationKind = ParticipationKind.SOURCE;
    ImmutableEntityReference participant = null;

    // Act and Assert
    thrown.expect(NullPointerException.class);
    physicalFlowParticipantDao.remove(physicalFlowId, participationKind, participant);
  }
}
