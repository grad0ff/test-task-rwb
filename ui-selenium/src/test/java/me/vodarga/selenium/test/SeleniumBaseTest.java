package me.vodarga.selenium.test;

import static me.vodarga.core.config.CoreConfig.CORE_CFG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseTest {

  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  public WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  @BeforeMethod
  public void setUp() {
    var driver = getDriver();
    if (driver == null) {
      driver = new ChromeDriver();
      driverThreadLocal.set(driver);
      driver.manage().window().maximize();
    }
    if (driver.getCurrentUrl().startsWith(CORE_CFG.baseUrl())) {
      driver.manage().deleteAllCookies();
      var js = (JavascriptExecutor) driver;
      js.executeScript("window.localStorage.clear();");
      js.executeScript("window.sessionStorage.clear();");
    }
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
    var driver = getDriver();
    if (driver != null) {
      driver.quit();
      driverThreadLocal.remove();
    }
  }

}
