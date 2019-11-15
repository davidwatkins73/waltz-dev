package com.khartec.waltz.data;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchUtilitiesTest {  
  @Test
  public void mkTermsTest() throws Exception {
    // Arrange
    String query = "aaaaa";

    // Act
    List<String> actual = SearchUtilities.mkTerms(query);

    // Assert
    assertEquals(1, actual.size());
  }
}
