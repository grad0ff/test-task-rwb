package me.vodarga.selenium.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@Sources("classpath:selenium.properties")
public interface SeleniumConfig extends Config {

  SeleniumConfig SELENIUM_CFG = ConfigFactory.create(SeleniumConfig.class);

  @Key("webdriver.path")
  String webdriverPath();

}
