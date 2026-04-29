package me.vodarga.selenium.gui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

  private static final String PATH = "/lk/basket";

  public BasketPage(WebDriver driver) {
    super(driver);
  }

  public String path() {
    return PATH;
  }

  public By goodWithId(int goodId) {
    return By.xpath("//*[@data-nm='%s']//ancestor::div[@class='list-item__wrap']".formatted(goodId));
  }


}
