package com.khartec.waltz.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class MapUtilitiesTest {

  @Test
  public void composeTest() throws Exception {
    // Arrange
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("aaaaa", "aaaaa");

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object, Object>compose(hashMap, hashMap);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void ensureNotNullTest() throws Exception {
    // Arrange
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("aaaaa", "aaaaa");

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>ensureNotNull(hashMap);

    // Assert
    assertTrue(actual instanceof HashMap);
  }

  @Test
  public void isEmptyTest() throws Exception {
    // Arrange
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("aaaaa", "aaaaa");

    // Act
    boolean actual = MapUtilities.<Object, Object>isEmpty(hashMap);

    // Assert
    assertFalse(actual);
  }

  @Test
  public void maybeGetTest() throws Exception {
    // Arrange
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("aaaaa", "aaaaa");
    String key = "aaaaa";

    // Act
    Optional<Object> actual = MapUtilities.<Object, Object>maybeGet(hashMap, key);

    // Assert
    assertEquals("Optional[aaaaa]", actual.toString());
  }

  @Test
  public void newHashMapTest() throws Exception {
    // Arrange
    String k1 = "aaaaa";
    String v1 = "aaaaa";
    String k2 = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(k1, v1, k2, k1, v1, k2, k1, v1, k2, k1);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void newHashMapTest2() throws Exception {
    // Arrange and Act
    HashMap<Object, Object> actual = MapUtilities.<Object, Object>newHashMap();

    // Assert
    assertEquals(0, actual.size());
  }

  @Test
  public void newHashMapTest3() throws Exception {
    // Arrange
    String k1 = "aaaaa";
    String v1 = "aaaaa";
    String k2 = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(k1, v1, k2, k1);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void newHashMapTest4() throws Exception {
    // Arrange
    String k1 = "aaaaa";
    String v1 = "aaaaa";
    String k2 = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(k1, v1, k2, k1, v1, k2, k1, v1);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void newHashMapTest5() throws Exception {
    // Arrange
    String k1 = "aaaaa";
    String v1 = "aaaaa";
    String k2 = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(k1, v1, k2, k1, v1, k2);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void newHashMapTest6() throws Exception {
    // Arrange
    String key = "aaaaa";
    String val = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(key, val);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void newHashMapTest7() throws Exception {
    // Arrange
    String k1 = "aaaaa";
    String v1 = "aaaaa";
    String k2 = "aaaaa";

    // Act
    Map<Object, Object> actual = MapUtilities.<Object, Object>newHashMap(k1, v1, k2, k1, v1, k2, k1, v1, k2, k1, v1,
        k2);

    // Assert
    assertEquals(1, actual.size());
  }
}
