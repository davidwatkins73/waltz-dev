package com.khartec.waltz.common;

import com.sun.org.apache.xerces.internal.dom.CoreDocumentImpl;
import org.junit.Test;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class XmlUtilitiesTest {

  @Test
  public void createNonValidatingDocumentBuilderFactoryTest() throws Exception {
    // Arrange and Act
    DocumentBuilderFactory actual = XmlUtilities.createNonValidatingDocumentBuilderFactory();

    // Assert
    assertFalse(actual.isIgnoringComments());
  }

  @Test
  public void printDocumentTest() throws Exception {
    // Arrange
    CoreDocumentImpl doc = new CoreDocumentImpl();
    boolean prettyPrint = true;

    // Act
    String actual = XmlUtilities.printDocument(doc, prettyPrint);

    // Assert
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n", actual);
  }

  @Test
  public void printDocumentTest2() throws Exception {
    // Arrange
    CoreDocumentImpl coreDocumentImpl = new CoreDocumentImpl();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    boolean prettyPrint = true;

    // Act
    XmlUtilities.printDocument(coreDocumentImpl, out, prettyPrint);

    // Assert
    assertEquals(null, coreDocumentImpl.getEncoding());
  }

  @Test
  public void streamTest() throws Exception {
    // Arrange
    IIOMetadataNode iIOMetadataNode = new IIOMetadataNode();

    // Act
    XmlUtilities.stream(iIOMetadataNode);

    // Assert
    assertEquals(null, iIOMetadataNode.getLocalName());
  }
}
