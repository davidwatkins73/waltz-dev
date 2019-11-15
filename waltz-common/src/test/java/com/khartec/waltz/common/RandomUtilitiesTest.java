package com.khartec.waltz.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RandomUtilitiesTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void randomIntBetweenTest() throws Exception {
    // Arrange
    int lower = 1;
    int upper = 1;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    RandomUtilities.randomIntBetween(lower, upper);
  }

  @Test
  public void randomPickTest() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");
    int howMany = 1;

    // Act
    List<Object> actual = RandomUtilities.<Object>randomPick(arrayList, howMany);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void randomPickTest2() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Object actual = RandomUtilities.<Object>randomPick((java.util.Collection<Object>) arrayList);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void randomPickTest3() throws Exception {
    // Arrange
    ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add("aaaaa");

    // Act
    Object actual = RandomUtilities.<Object>randomPick((java.util.List<Object>) arrayList);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void randomPickTest4() throws Exception {
    // Arrange
    Object[] ts = new Object[]{"aaaaa", "aaaaa", "aaaaa"};

    // Act
    Object actual = RandomUtilities.<Object>randomPick(ts);

    // Assert
    assertEquals("aaaaa", actual);
  }

  @Test
  public void randomlySizedIntStreamTest() throws Exception {
    // Arrange
    int lower = 1;
    int upper = 1;

    // Act and Assert
    thrown.expect(IllegalArgumentException.class);
    RandomUtilities.randomlySizedIntStream(lower, upper);
  }
}
