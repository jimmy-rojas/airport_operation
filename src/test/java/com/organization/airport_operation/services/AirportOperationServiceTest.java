package com.organization.airport_operation.services;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@RunWith(MockitoJUnitRunner.class)
public class AirportOperationServiceTest {

  private AirportOperationService instance;
  private ResourceFileService resourceFileService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    this.resourceFileService = new ResourceFileService();

    Resource r = new ClassPathResource("data.json");
    org.springframework.test.util.ReflectionTestUtils
        .setField(this.resourceFileService, "fileResource", r);

    this.resourceFileService.init();

    this.instance = new AirportOperationService(this.resourceFileService);
  }

  @Test (expected = IOException.class)
  public void loadData_invalid_data() throws Exception {
    ResourceFileService resourceFileService = new ResourceFileService();

    org.springframework.test.util.ReflectionTestUtils.setField(
        resourceFileService, "fileResource", new ClassPathResource("invalid_data.json"));

    resourceFileService.init();

    AirportOperationService instance = new AirportOperationService(resourceFileService);
    instance.init();
  }

  @Test
  public void loadData() throws Exception {
    this.instance.init();
  }

}