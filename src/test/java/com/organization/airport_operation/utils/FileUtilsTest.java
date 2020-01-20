package com.organization.airport_operation.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileUtilsTest {

  @Test
  public void getFileFromResource() throws Exception {
    Resource resource = new ClassPathResource("data.json");
    File file = FileUtils.getFileFromResource(resource);
    assertNotNull(file);
    assertTrue(file.exists());
    assertTrue(file.delete());
  }

  @Test (expected = IOException.class)
  public void getFileFromResource_IOException() throws Exception {
    Resource resource = new ClassPathResource("file.txt");
    FileUtils.getFileFromResource(resource);
  }

}