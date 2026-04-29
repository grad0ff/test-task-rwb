package me.vodarga.selenide.gui.page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class CardPage {

  private static final String PATH = "/catalog/%s/detail.aspx";

  public String path(int goodId) {
    return PATH.formatted(goodId);
  }

  public SelenideElement addToBasketBtn() {
    return $x("//div[contains(@class, 'productPageContent')]//button[@aria-label='Добавить в корзину']")
        .as("Кнопка 'Добавить в корзину'");
  }

  public SelenideElement inBasketBtn() {
    return $x("//div[contains(@class, 'productPageContent')]//button[@aria-label='В корзине']")
        .as("Кнопка 'В корзине'");
  }

}
