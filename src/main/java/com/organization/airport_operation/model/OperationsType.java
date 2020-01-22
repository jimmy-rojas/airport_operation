package com.organization.airport_operation.model;

import com.google.gson.annotations.SerializedName;

public enum OperationsType {
  @SerializedName("arrive") ARRIVE,
  @SerializedName("departure") DEPARTURE;

}
