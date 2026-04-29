package me.vodarga.selenium.test;

import static me.vodarga.core.config.CoreConfig.CORE_CFG;
import static me.vodarga.selenium.config.SeleniumConfig.SELENIUM_CFG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBaseTest {

  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  public WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  @BeforeSuite
  public void beforeSuite() {
    System.setProperty("webdriver.chrome.driver", SELENIUM_CFG.webdriverPath());
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
