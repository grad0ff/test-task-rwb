package me.vodarga.selenium.util;

import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public final class Awaiter {

  private Duration timeout = ofSeconds(5);
  private WebDriver driver;

  private Awaiter() {
  }

  public static TimeoutStep forDriver(WebDriver driver) {
    return new Builder().forDriver(driver);
  }


  private static class Builder implements TimeoutStep, FunctionStep {

    private final Awaiter awaiter;

    private Builder() {
      awaiter = new Awaiter();
    }

    public TimeoutStep forDriver(WebDriver driver) {
      awaiter.driver = driver;
      return this;
    }

    public FunctionStep await(Duration timeout) {
      awaiter.timeout = timeout;
      return this;
    }

    public FunctionStep await() {
      return this;
    }

    public <T> T until(Function<? super WebDriver, T> driverFunction) {
      return new FluentWait<>(awaiter.driver)
          .withTimeout(awaiter.timeout)
          .ignoring(NoSuchElementException.class)
          .until(driverFunction);
    }

  }

}
