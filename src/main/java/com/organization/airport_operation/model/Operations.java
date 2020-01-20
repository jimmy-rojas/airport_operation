package com.organization.airport_operation.model;

public class Operations {

  private String type;
  private int id;
  private int plane_id;
  private int terminal_id;
  private String time;
  private String status;
  private String spent_time;
  private String planned_time;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPlane_id() {
    return plane_id;
  }

  public void setPlane_id(int plane_id) {
    this.plane_id = plane_id;
  }

  public int getTerminal_id() {
    return terminal_id;
  }

  public void setTerminal_id(int terminal_id) {
    this.terminal_id = terminal_id;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSpent_time() {
    return spent_time;
  }

  public void setSpent_time(String spent_time) {
    this.spent_time = spent_time;
  }

  public String getPlanned_time() {
    return planned_time;
  }

  public void setPlanned_time(String planned_time) {
    this.planned_time = planned_time;
  }
}
