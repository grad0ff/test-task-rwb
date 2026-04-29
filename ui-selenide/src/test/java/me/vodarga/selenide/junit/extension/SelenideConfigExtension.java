package me.vodarga.selenide.junit.extension;

import static me.vodarga.core.config.CoreConfig.CORE_CFG;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SelenideConfigExtension implements SuiteExtension, BeforeEachCallback {

  @Override
  public void beforeSuite(ExtensionContext context) {
    Configuration.reportsFolder = "target/reports/tests";
    Configuration.downloadsFolder = "target/downloads";
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = CORE_CFG.baseUrl();
  }

  @Override
  public void beforeEach(ExtensionContext context) {
    if (WebDriverRunner.hasWebDriverStarted()) {
      Selenide.clearBrowserCookies();
      Selenide.clearBrowserLocalStorage();
      Selenide.executeJavaScript("window.sessionStorage.clear();");
    }
  }

}
