package com.organization.airport_operation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportOperationService {

  private ResourceFileService resourceFileService;

  @Autowired
  public AirportOperationService(ResourceFileService resourceFileService) {
    this.resourceFileService = resourceFileService;
  }
}
