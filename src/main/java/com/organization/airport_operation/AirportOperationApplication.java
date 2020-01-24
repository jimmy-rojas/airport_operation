package com.organization.airport_operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirportOperationApplication {

  public static void main(String[] args) {
    SpringApplication.run(AirportOperationApplication.class, args);
  }

}
