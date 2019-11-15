package com.khartec.waltz.data;

import org.jooq.SQLDialect;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class JooqUtilitiesTest {

  @Test
  public void isMariaDBTest() throws Exception {
    // Arrange
    SQLDialect dialect = SQLDialect.SQL99;

    // Act
    boolean actual = JooqUtilities.isMariaDB(dialect);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void isPostgresTest() throws Exception {
    // Arrange
    SQLDialect dialect = SQLDialect.SQL99;

    // Act
    boolean actual = JooqUtilities.isPostgres(dialect);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void isSQLServerTest() throws Exception {
    // Arrange
    SQLDialect dialect = SQLDialect.SQL99;

    // Act
    boolean actual = JooqUtilities.isSQLServer(dialect);

    // Assert
    assertFalse(actual);
  }
}
