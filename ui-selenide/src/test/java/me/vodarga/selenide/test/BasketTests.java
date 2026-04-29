package me.vodarga.selenide.test;

import me.vodarga.selenide.test.steps.BasketTestsSteps;
import org.junit.jupiter.api.Test;

public class BasketTests extends SelenideBaseTest {

  private final BasketTestsSteps steps = new BasketTestsSteps();

  @Test
  void addItemToBasket() {
    int goodId = 264220770;

    steps.openCardForGood(goodId)
        .addGoodToBasket()
        .goToBasket()
        .assertGoodAddedToBasket(goodId);
  }

}
