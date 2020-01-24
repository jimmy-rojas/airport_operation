package com.organization.airport_operation.model;

public class Planes {

  private int id;
  private String name;
  private int airline_id;
  private int capacity;
  private String category;

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

  public int getAirline_id() {
    return airline_id;
  }

  public void setAirline_id(int airline_id) {
    this.airline_id = airline_id;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
