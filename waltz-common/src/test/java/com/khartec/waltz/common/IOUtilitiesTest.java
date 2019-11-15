package com.khartec.waltz.common;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IOUtilitiesTest {

  @Test
  public void copyStreamTest() throws Exception {
    // Arrange
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    IOUtilities.copyStream(byteArrayInputStream, output);

    // Assert
    assertEquals(0, byteArrayInputStream.available());
  }

  @Test
  public void getFileResourceTest() throws Exception {
    // Arrange
    String fileName = "aaaaa";

    // Act
    Resource actual = IOUtilities.getFileResource(fileName);

    // Assert
    String path = ((FileSystemResource) actual).getPath();
    assertEquals("aaaaa", actual.getFilename());
  }

  @Test
  public void readAsStringTest() throws Exception {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    // Act
    String actual = IOUtilities.readAsString(stream);

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actual);
  }

  @Test
  public void readLinesTest() throws Exception {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    // Act
    List<String> actual = IOUtilities.readLines(stream);

    // Assert
    assertEquals(1, actual.size());
  }

  @Test
  public void streamLinesTest() throws Exception {
    // Arrange
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    // Act
    IOUtilities.streamLines(byteArrayInputStream);

    // Assert
    assertEquals(24, byteArrayInputStream.available());
  }
}
