package com.organization.airport_operation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.springframework.core.io.Resource;

public class FileUtils {

  public static File getFileFromResource(Resource file) throws IOException {
    if (!file.exists() || !file.isReadable()) {
      throw new IOException("Unable to find resource");
    }
    File newFile = new File(file.getFilename());
    if (newFile.exists() && newFile.canWrite()) {
      newFile.delete();
    }
    if (!newFile.createNewFile() || !newFile.canWrite()) {
      throw new IOException("It was unable to provide a new file");
    }
    try (final FileOutputStream fos = new FileOutputStream(newFile)) {
      String text = null;
      try (final Reader reader = new InputStreamReader(file.getInputStream())) {
        char[] arr = new char[8 * 1024];
        StringBuilder buffer = new StringBuilder();
        int numCharsRead;
        while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
          buffer.append(arr, 0, numCharsRead);
        }
        text = buffer.toString();
      }

      fos.write(text.getBytes());
    }
    return newFile;
  }

  public static File getFileOutputResource(Resource file) throws IOException {
    File newFile = new File(file.getFilename());
    if (newFile.exists() && newFile.canWrite()) {
      newFile.delete();
    }
    if (!newFile.createNewFile() || !newFile.canWrite()) {
      throw new IOException("It was unable to provide a new file");
    }
    return newFile;
  }

}
