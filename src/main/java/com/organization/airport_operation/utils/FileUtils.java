package com.organization.airport_operation.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {

  public static File getFileInOut(String filePath, boolean isNew) throws IOException {
    File newFile = new File(filePath);
    if (isNew) {
      if (newFile.exists() && newFile.canWrite()) {
        newFile.delete();
      }
      if (!newFile.createNewFile() || !newFile.canWrite()) {
        throw new IOException("It was unable to provide a new file");
      }
    } else if (!newFile.exists() || !newFile.canWrite()) {
      throw new IOException("It was unable to provide a existing file");
    }
    return newFile;
  }

}
