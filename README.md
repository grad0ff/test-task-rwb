# RWB. Тестовое задание

## Описание задания

### Цель проверки

Возможность добавления товара в корзину.

### Шаги

1. Открыть страницу товара https://www.wildberries.by/catalog/264220770/detail.aspx.
2. Нажать на кнопку "Добавить в корзину".
3. Кликнуть на кнопку "В корзине".
4. Проверить, что добавленный товар находится в корзине.

## Реализация проверок

### Описание проекта

Структура:

- [core](core) - содержит общий код для модулей
- [ui-selenide](ui-selenide) - содержит реализацию для связки JUnit + Selenide
- [ui-selenium](ui-selenium) - содержит проверки для связки TestNG + Selenium

### Запуск тестов

#### JUnit + Selenide:

```shell
mvn clean test -pl ui-selenide -am
```

#### TestNG + Selenium:

```shell
mvn clean test -pl ui-selenium -am
```

#### Все тесты:

```shell
mvn clean test
```
