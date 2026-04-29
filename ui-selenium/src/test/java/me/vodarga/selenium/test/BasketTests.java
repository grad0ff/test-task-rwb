package me.vodarga.selenium.test;

import me.vodarga.selenium.test.steps.BasketTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketTests extends SeleniumBaseTest {

  private BasketTestsSteps steps;

  @BeforeMethod
  @Override
  public void setUp() {
    super.setUp();
    steps = new BasketTestsSteps(getDriver());
  }

  @Test
  void addItemToBasket() {
    int goodId = 264220770;

    steps.openCardForGood(goodId)
        .addGoodToBasket()
        .goToBasket()
        .assertGoodAddedToBasket(goodId);
  }

}
