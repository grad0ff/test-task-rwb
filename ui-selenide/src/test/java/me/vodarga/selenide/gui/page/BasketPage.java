package me.vodarga.selenide.gui.page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class BasketPage {

  private static final String PATH = "/lk/basket";

  public String path() {
    return PATH;
  }

  public SelenideElement goodWithId(int goodId) {
    return $x("//*[@data-nm='%s']//ancestor::div[@class='list-item__wrap']".formatted(goodId))
        .as("Товар с ID='%s' в корзине".formatted(goodId));
  }

}
