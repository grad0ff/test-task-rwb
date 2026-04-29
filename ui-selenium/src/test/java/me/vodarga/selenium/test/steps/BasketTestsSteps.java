package me.vodarga.selenium.test.steps;

import static java.time.Duration.ofSeconds;
import static me.vodarga.core.config.CoreConfig.CORE_CFG;
import static org.testng.Assert.assertTrue;

import me.vodarga.selenium.gui.page.BasketPage;
import me.vodarga.selenium.gui.page.CardPage;
import me.vodarga.selenium.util.Awaiter;
import org.openqa.selenium.WebDriver;

public class BasketTestsSteps {

  private final WebDriver driver;
  private final CardPage cardPage;
  private final BasketPage basketPage;

  public BasketTestsSteps(WebDriver driver) {
    this.driver = driver;
    this.cardPage = new CardPage(driver);
    this.basketPage = new BasketPage(driver);
  }

  // @Step("Открыть карточку товара с ID={goodId}")
  public BasketTestsSteps openCardForGood(int goodId) {
    driver.get(CORE_CFG.baseUrl() + cardPage.path(goodId));
    Awaiter.forDriver(driver)
        .await(ofSeconds(10))
        .until(d -> d.findElement(cardPage.container()).isDisplayed());
    return this;
  }

  // @Step("Добавить товар в корзину")
  public BasketTestsSteps addGoodToBasket() {
    cardPage.addGoodToBasket();
    return this;
  }

  // @Step("Перейти на страницу корзины")
  public BasketTestsSteps goToBasket() {
    cardPage.goToBasket();
    return this;
  }

  // @Step("Проверить наличие товара с ID={goodId} в корзине")
  public void assertGoodAddedToBasket(int goodId) {
    Awaiter.forDriver(driver)
        .await(ofSeconds(10))
        .until(d -> d.findElement(basketPage.container()).isDisplayed());
    assertTrue(driver.findElement(basketPage.goodWithId(goodId)).isDisplayed(),
        "Товар с ID=%s не отображается в корзине".formatted(goodId));
  }

}
