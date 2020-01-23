package com.organization.airport_operation.services;

import com.organization.airport_operation.exceptions.NotFoundException;
import com.organization.airport_operation.model.Airlines;
import com.organization.airport_operation.model.Airport;
import com.organization.airport_operation.model.AirportData;
import com.organization.airport_operation.model.Operations;
import com.organization.airport_operation.model.OperationsType;
import com.organization.airport_operation.model.Planes;
import com.organization.airport_operation.model.Terminals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportOperationService {

  private IAirportDataSource dataSource;

  private Airport airport;
  private Map<Integer, Airlines> airlinesMap = new HashMap<>();
  private Map<Integer, Terminals> terminalsHashMap = new HashMap<>();
  private Map<Integer, Map<Integer, Planes>> airlinePlanesMap = new HashMap<>();
  private Map<OperationsType, List<Operations>> operationsMap = new HashMap<>();

  @Autowired
  public AirportOperationService(IAirportDataSource dataSource) {
    this.dataSource = dataSource;
  }

  @PostConstruct
  public void init() throws Exception {
    AirportData airportData = this.dataSource.loadAirportData();
    if (airportData != null) {
      airport = airportData.getAirport();
      processAirportData(airport);
    } else {
      throw new IOException("Unable to load main Airport Data.");
    }
  }

  private void processAirportData(Airport airport) {
    for (Airlines airline: airport.getAirlines()) {
      airlinesMap.put(airline.getId(), airline);
      Map<Integer, Planes> planeEntry = new HashMap<>();
      for (Planes plane : airline.getPlanes()) {
        planeEntry.put(plane.getId(), plane);
      }
      airlinePlanesMap.put(airline.getId(), planeEntry);
    }
    for (Terminals terminal : airport.getTerminals()) {
      terminalsHashMap.put(terminal.getId(), terminal);
    }
    for (Operations operation : airport.getOperations()) {
      if (!operationsMap.containsKey(operation.getType())) {
        operationsMap.put(operation.getType(), new ArrayList<>());
      }
      operationsMap.get(operation.getType()).add(operation);
    }
  }

  public synchronized void saveData() throws Exception {
    AirportData airportData = new AirportData();
    Airport airport = new Airport();
    airport.setId(this.airport.getId());
    airport.setName(this.airport.getName());
    List<Airlines> airlines = new ArrayList<>();
    for (Airlines airline : airlinesMap.values()) {
      airlines.add(airline);
    }

    List<Operations> operations = new ArrayList<>();
    operationsMap.keySet().forEach(
        operationsType -> operations.addAll(operationsMap.get(operationsType))
    );

    List<Terminals> terminals = new ArrayList<>();
    terminalsHashMap.keySet().forEach(id -> terminals.add(terminalsHashMap.get(id)));

    airport.setOperations(operations);
    airport.setAirlines(airlines);
    airport.setTerminals(terminals);
    airportData.setAirport(airport);
    this.dataSource.saveAirportData(airportData);
  }

  public Airlines getAirlinesById(int i) throws NotFoundException {
    if (!airlinesMap.containsKey(i)) {
      throw new NotFoundException("No Airline was found with that id: " + i);
    }
    return airlinesMap.get(i);
  }

  public List<Planes> getPlanesByAirlineId(int i) throws NotFoundException {
    if (!airlinePlanesMap.containsKey(i)) {
      throw new NotFoundException("No Planes were found for that AirlineId: " + i);
    }
    return airlinePlanesMap.get(i).values()
        .stream()
        .collect(Collectors.toList());
  }

  public List<Operations> getOperationsByType(OperationsType type) throws NotFoundException {
    if (!operationsMap.containsKey(type)) {
      throw new NotFoundException("No Operations were found for that OperationsType: " + type);
    }
    return operationsMap.get(type);
  }

  public void saveOperationsByType() throws Exception {
    this.dataSource.saveAirportData(operationsMap);
  }
}
