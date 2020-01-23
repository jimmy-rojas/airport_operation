package com.organization.airport_operation.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.organization.airport_operation.model.AirportData;
import com.organization.airport_operation.utils.FileUtils;
import com.organization.airport_operation.utils.LoggerHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class ResourceFileService implements IAirportDataSource {

  private File resourceFile;
  private File resourceFileOutput;

  @PostConstruct
  public void init() throws IOException {
    resourceFile = FileUtils.getFileInOut("data-input.json", false);
    resourceFileOutput = FileUtils.getFileInOut("data-output.json", true);
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

  @Override
  public void saveAirportData(Object airportData) throws Exception {

    long startProcessingTime = System.currentTimeMillis();

    Gson gson = new Gson();
    try (FileWriter writer = new FileWriter(resourceFileOutput)) {
      gson.toJson(airportData, writer);
    } catch (IOException e) {
      throw new IOException("It was unable to save into file");
    }

    long totalProcessingTimeThreads = System.currentTimeMillis() - startProcessingTime;
    LoggerHelper.info("saveAirportData Ended: " + totalProcessingTimeThreads);
  }
}
