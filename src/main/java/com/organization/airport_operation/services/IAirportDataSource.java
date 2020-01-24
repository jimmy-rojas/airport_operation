package com.organization.airport_operation.services;

import com.organization.airport_operation.model.AirportData;

public interface IAirportDataSource {

  AirportData loadAirportData() throws Exception;

  void saveAirportData(Object airportData) throws Exception;
}
