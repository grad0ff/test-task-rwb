package me.vodarga.selenide.test.steps;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.Selenide;
import me.vodarga.selenide.gui.page.BasketPage;
import me.vodarga.selenide.gui.page.CardPage;

public class BasketTestsSteps {

  private final CardPage cardPage = new CardPage();
  private final BasketPage basketPage = new BasketPage();

  // @Step("Открыть карточку товара с ID={goodId}")
  public BasketTestsSteps openCardForGood(int goodId) {
    Selenide.open(cardPage.path(goodId));
    return this;
  }

  // @Step("Добавить товар в корзину")
  public BasketTestsSteps addGoodToBasket() {
    cardPage.addToBasketBtn().shouldBe(visible, ofSeconds(10)).click();
    return this;
  }

  // @Step("Перейти на страницу корзины")
  public BasketTestsSteps goToBasket() {
    cardPage.inBasketBtn().should(appear).click();
    return this;
  }

  // @Step("Проверить наличие товара с ID={goodId} в корзине")
  public void assertGoodAddedToBasket(int goodId) {
    basketPage.goodWithId(goodId).shouldBe(visible, ofSeconds(10));
  }

}
