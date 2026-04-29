package me.vodarga.selenium.gui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage extends BasePage {

  private static final String PATH = "/catalog/%s/detail.aspx";

  public CardPage(WebDriver driver) {
    super(driver);
  }

  public String path(int goodId) {
    return PATH.formatted(goodId);
  }

  public By addToBasketBtn() {
    return By.xpath("//div[contains(@class, 'productPageContent')]//button[@aria-label='Добавить в корзину']");
  }

  public By inBasketBtn() {
    return By.xpath("//div[contains(@class, 'productPageContent')]//button[@aria-label='В корзине']");
  }

  public CardPage addGoodToBasket() {
    driver.findElement(addToBasketBtn()).click();
    return this;
  }

  public BasketPage goToBasket() {
    driver.findElement(inBasketBtn()).click();
    return new BasketPage(driver);
  }

}
