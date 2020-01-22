package com.organization.airport_operation.services;

import com.organization.airport_operation.model.Airport;
import com.organization.airport_operation.model.AirportData;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportOperationService {

  private IAirportDataSource dataSource;
  private Airport airport;

  @Autowired
  public AirportOperationService(IAirportDataSource dataSource) {
    this.dataSource = dataSource;
  }

  @PostConstruct
  public void init() throws Exception {
    AirportData airportData = this.dataSource.loadAirportData();
    if (airportData != null) {
      airport = airportData.getAirport();
    } else {
      throw new IOException("Unable to load main Airport Data.");
    }
  }

}
