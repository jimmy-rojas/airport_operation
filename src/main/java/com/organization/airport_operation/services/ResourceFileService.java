package com.organization.airport_operation.services;

import com.organization.airport_operation.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Scope(value = "singleton")
@Service
public class ResourceFileService {

  @Value("classpath:data.json")
  private Resource fileResource;

  private File resourceFile;

  @PostConstruct
  public void init() throws IOException {
    resourceFile = FileUtils.getFileFromResource(fileResource);
  }

  public File getResourceFile() {
    return resourceFile;
  }
}
