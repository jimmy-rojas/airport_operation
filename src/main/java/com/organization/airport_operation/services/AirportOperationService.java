package com.organization.airport_operation.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.organization.airport_operation.model.Airport;
import com.organization.airport_operation.model.AirportData;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportOperationService {

  private ResourceFileService resourceFileService;
  private Airport airport;

  @Autowired
  public AirportOperationService(ResourceFileService resourceFileService) {
    this.resourceFileService = resourceFileService;
  }

  public synchronized void loadData() throws IOException {
    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new FileReader(this.resourceFileService.getResourceFile()));
    AirportData airportData = gson.fromJson(reader, AirportData.class);
    if (airportData != null) {
      airport = airportData.getAirport();
    } else {
      throw new IOException("Unable to load main Airport Data.");
    }
  }

}
