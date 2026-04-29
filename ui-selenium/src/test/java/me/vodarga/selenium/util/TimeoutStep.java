package me.vodarga.selenium.util;

import java.time.Duration;

public interface TimeoutStep {

  FunctionStep await(Duration timeout);

  FunctionStep await();

}