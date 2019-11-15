package com.khartec.waltz.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.xml.sax.SAXParseException;

public class SvgUtilitiesTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void convertVisioSvgTest() throws Exception {
    // Arrange
    String key = "aaaaa";
    String svgStr = "aaaaa";

    // Act and Assert
    thrown.expect(SAXParseException.class);
    SvgUtilities.convertVisioSvg(key, svgStr);
  }
}
