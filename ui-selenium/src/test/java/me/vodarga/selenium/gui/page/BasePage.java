package me.vodarga.selenium.gui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  protected final WebDriver driver;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public By container() {
    return By.xpath("//div[@id='reactContainers']");
  }

}
