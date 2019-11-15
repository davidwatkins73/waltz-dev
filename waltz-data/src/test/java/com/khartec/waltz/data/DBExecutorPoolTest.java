package com.khartec.waltz.data;

import org.junit.Test;

public class DBExecutorPoolTest {
  @Test
  public void DBExecutorPoolTest() throws Exception {
    // Arrange
    int dbPoolMin = 1;
    int dbPoolMax = 1;

    // Act
    new DBExecutorPool(dbPoolMin, dbPoolMax);
  }
}
