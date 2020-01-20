package com.organization.airport_operation.model;

import java.util.List;

public class Airport {

  private int id;
  private String name;
  private List<Airlines> airlines;
  private List<Terminals> terminals;
  private List<Operations> operations;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Airlines> getAirlines() {
    return airlines;
  }

  public void setAirlines(List<Airlines> airlines) {
    this.airlines = airlines;
  }

  public List<Terminals> getTerminals() {
    return terminals;
  }

  public void setTerminals(List<Terminals> terminals) {
    this.terminals = terminals;
  }

  public List<Operations> getOperations() {
    return operations;
  }

  public void setOperations(List<Operations> operations) {
    this.operations = operations;
  }

}
