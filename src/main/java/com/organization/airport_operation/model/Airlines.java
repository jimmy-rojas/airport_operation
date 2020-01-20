package com.organization.airport_operation.model;

import java.util.List;

public class Airlines {

  private int id;
  private String name;
  private List<Planes> planes;

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

  public List<Planes> getPlanes() {
    return planes;
  }

  public void setPlanes(List<Planes> planes) {
    this.planes = planes;
  }

}
