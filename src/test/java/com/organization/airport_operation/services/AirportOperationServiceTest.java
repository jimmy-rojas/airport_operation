package com.organization.airport_operation.services;

import static org.junit.Assert.*;

import com.organization.airport_operation.exceptions.NotFoundException;
import com.organization.airport_operation.model.Airlines;
import com.organization.airport_operation.model.Operations;
import com.organization.airport_operation.model.OperationsType;
import com.organization.airport_operation.model.Planes;
import java.io.IOException;
import java.util.List;
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

    r = new ClassPathResource("dataOutput.json");
    org.springframework.test.util.ReflectionTestUtils
        .setField(this.resourceFileService, "fileOutputResource", r);

    this.resourceFileService.init();

    this.instance = new AirportOperationService(this.resourceFileService);
  }

  @Test (expected = IOException.class)
  public void loadData_invalid_data() throws Exception {
    ResourceFileService resourceFileService = new ResourceFileService();

    org.springframework.test.util.ReflectionTestUtils.setField(
        resourceFileService, "fileResource", new ClassPathResource("invalid_data.json"));
    org.springframework.test.util.ReflectionTestUtils.setField(
        resourceFileService, "fileOutputResource", new ClassPathResource("dataOutput.json"));

    resourceFileService.init();

    AirportOperationService instance = new AirportOperationService(resourceFileService);
    instance.init();
  }

  @Test
  public void loadData() throws Exception {
    this.instance.init();
  }

  @Test
  public void saveData() throws Exception {
    this.instance.init();
    this.instance.saveData();
  }

  @Test (expected = NotFoundException.class)
  public void getAirlinesById_NotFoundException() throws Exception {
    this.instance.init();
    this.instance.getAirlinesById(0);
  }

  @Test
  public void getAirlinesById() throws Exception {
    this.instance.init();
    Airlines airline = this.instance.getAirlinesById(1);
    assertNotNull(airline);
  }

  @Test
  public void getPlanesByAirlineId() throws Exception {
    this.instance.init();
    List<Planes> planes = this.instance.getPlanesByAirlineId(1);
    assertNotNull(planes);
  }

  @Test
  public void getOperationsByType() throws Exception {
    this.instance.init();
    List<Operations> operations = this.instance.getOperationsByType(OperationsType.ARRIVE);
    assertNotNull(operations);
    assertEquals(1, operations.size());
  }

  /*@Test
  public void addAirline_() throws Exception {
    this.instance.init();
//    Airlines airline = new Airlines();
//    airline.setId(2);
//    airline.setName("LATAM Airlines");
    Airlines airline = this.instance.getAirlinesById(1);
    airline.setName("NEW NANE");
    this.instance.saveData();
  }*/

}