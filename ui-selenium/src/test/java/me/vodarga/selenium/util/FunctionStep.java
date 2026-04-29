package me.vodarga.selenium.util;

import java.util.function.Function;
import org.openqa.selenium.WebDriver;

public interface FunctionStep {

  <T> T until(Function<? super WebDriver, T> driverFunction);

}
