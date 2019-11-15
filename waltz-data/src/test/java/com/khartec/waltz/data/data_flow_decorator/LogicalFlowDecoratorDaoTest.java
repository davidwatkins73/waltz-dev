package com.khartec.waltz.data.data_flow_decorator;

import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.EntityReference;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.data_flow_decorator.LogicalFlowDecorator;
import com.khartec.waltz.model.rating.AuthoritativenessRating;
import org.jooq.Condition;
import org.jooq.exception.DetachedException;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class LogicalFlowDecoratorDaoTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void LogicalFlowDecoratorDaoTest() throws Exception {
    // Arrange
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(new DefaultConfiguration());

    // Act
    new LogicalFlowDecoratorDao(defaultDSLContext);

    // Assert
    assertEquals(
        "DefaultConfiguration [\n\tconnected=false,\n\ttransactional=false,\n\tdialect=DEFAULT,\n\tdata={},\n\tsettings=\n\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderNameStyle>QUOTED</renderNameStyle><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions><renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination><backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT</paramCastMode><statementType>PREPARED_STATEMENT</statementType><executeLogging>true</executeLogging><executeWithOptimisticLocking>false</executeWithOptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLockingExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions>THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServerOutputSize><returnAllOnUpdatableRecord>false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations>true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfoOnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2</inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere><executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><parseWithMetaLookups>IGNORE_ON_FAILURE</parseWithMetaLookups><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions>FAIL</parseUnknownFunctions>\n]",
        defaultDSLContext.toString());
  }

  @Test
  public void addDecoratorsTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<LogicalFlowDecorator> arrayList = new ArrayList<LogicalFlowDecorator>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDecoratorDao.addDecorators(arrayList);
  }

  @Test
  public void deleteDecoratorsTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    Long flowId = new Long(1L);
    ArrayList<EntityReference> arrayList = new ArrayList<EntityReference>();
    arrayList.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDecoratorDao.deleteDecorators(flowId, arrayList);
  }

  @Test
  public void findAllTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDecoratorDao.findAll();
  }

  @Test
  public void findByFlowIdsAndKindTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));
    EntityKind decorationKind = EntityKind.ACTOR;

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDecoratorDao.findByFlowIdsAndKind(arrayList, decorationKind);
  }

  @Test
  public void findByFlowIdsTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDecoratorDao.findByFlowIds(arrayList);
  }

  @Test
  public void getByFlowIdAndDecoratorRefTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    long flowId = 1L;
    ImmutableEntityReference decoratorRef = null;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    logicalFlowDecoratorDao.getByFlowIdAndDecoratorRef(flowId, decoratorRef);
  }

  @Test
  public void removeAllDecoratorsForFlowIdsTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    ArrayList<Long> arrayList = new ArrayList<Long>();
    arrayList.add(new Long(1L));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDecoratorDao.removeAllDecoratorsForFlowIds(arrayList);
  }

  @Test
  public void summarizeForAllTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));

    // Act and Assert
    thrown.expect(DetachedException.class);
    logicalFlowDecoratorDao.summarizeForAll();
  }

  @Test
  public void updateDecoratorsTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    HashSet<LogicalFlowDecorator> hashSet = new HashSet<LogicalFlowDecorator>();
    hashSet.add(null);

    // Act and Assert
    thrown.expect(NullPointerException.class);
    logicalFlowDecoratorDao.updateDecorators(hashSet);
  }

  @Test
  public void updateRatingsByConditionTest() throws Exception {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(new DefaultConfiguration()));
    AuthoritativenessRating rating = AuthoritativenessRating.PRIMARY;
    Condition condition = Whitebox.newInstance(Condition.class);

    // Act and Assert
    thrown.expect(ClassCastException.class);
    logicalFlowDecoratorDao.updateRatingsByCondition(rating, condition);
  }
}
