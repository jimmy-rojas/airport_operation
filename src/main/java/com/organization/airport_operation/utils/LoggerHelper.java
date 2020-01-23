package com.organization.airport_operation.utils;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerHelper {

  private static boolean PRINT_STACK = true;
  private static Logger LOGGER = LoggerFactory.getLogger("AirportOperationApplication");

  @Value("${app.print-stack}")
  private boolean printStack;

  @Autowired
  public LoggerHelper() {
  }

  @PostConstruct
  public void initLogger() {
    PRINT_STACK = printStack;
  }

  public static void info(String msg) {
    LOGGER.info(msg);
  }

  public static void info(String msg, Throwable th) {
    if (PRINT_STACK) {
      LOGGER.info(msg, th);
    } else {
      LOGGER.info(msg);
    }
  }

  public static void warn(String msg) {
    LOGGER.warn(msg);
  }

  public static void warn(String msg, Throwable th) {
    if (PRINT_STACK) {
      LOGGER.warn(msg, th);
    } else {
      LOGGER.warn(msg);
    }
  }

  public static void error(String msg) {
    LOGGER.error(msg);
  }

  public static void error(String msg, Throwable th) {
    if (PRINT_STACK) {
      LOGGER.error(msg, th);
    } else {
      LOGGER.error(msg);
    }
  }

}
