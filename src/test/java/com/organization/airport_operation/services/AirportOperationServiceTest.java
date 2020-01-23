package com.organization.airport_operation.services;

import static org.junit.Assert.*;

import com.organization.airport_operation.exceptions.NotFoundException;
import com.organization.airport_operation.model.Airlines;
import com.organization.airport_operation.model.AirportData;
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

@RunWith(MockitoJUnitRunner.class)
public class AirportOperationServiceTest {

  private AirportOperationService instance;
  private ResourceFileService resourceFileService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    this.resourceFileService = new ResourceFileService();
    this.resourceFileService.init();

    this.instance = new AirportOperationService(this.resourceFileService);
  }

  @Test (expected = IOException.class)
  public void loadData_invalid_data() throws Exception {
    IAirportDataSource resourceFileServiceMock = new IAirportDataSource() {
      @Override
      public AirportData loadAirportData() throws Exception {
        throw  new IOException("test exception");
      }

      @Override
      public void saveAirportData(Object airportData) throws Exception {

      }
    };
    AirportOperationService instance = new AirportOperationService(resourceFileServiceMock);
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

  @Test
  public void saveOperationsByType() throws Exception {
    this.instance.init();
    this.instance.saveOperationsByType();
  }

}
