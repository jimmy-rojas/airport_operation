package com.organization.airport_operation.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.organization.airport_operation.model.AirportData;
import com.organization.airport_operation.utils.FileUtils;
import com.organization.airport_operation.utils.LoggerHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class ResourceFileService implements IAirportDataSource {

  @Value("classpath:data.json")
  private Resource fileResource;

  private File resourceFile;

  @PostConstruct
  public void init() throws IOException {
    resourceFile = FileUtils.getFileFromResource(fileResource);
  }

  @Override
  public AirportData loadAirportData() throws FileNotFoundException {
    long startProcessingTime = System.currentTimeMillis();

    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new FileReader(this.resourceFile));
    AirportData airportData = gson.fromJson(reader, AirportData.class);

    long totalProcessingTimeThreads = System.currentTimeMillis() - startProcessingTime;
    LoggerHelper.info("loadAirportData Ended: " + totalProcessingTimeThreads);

    return airportData;
  }
}
