package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.special.*;
import org.skypro.skyshop.search.Searchable;

public class App {

    public static void printSeparator() {
        System.out.println("======================================================");
    }

    public static void main(String[] args) {

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        Product product1 = new SimpleProduct("Степлер", 500);
        Product product2 = new SimpleProduct("Ручка гелевая синяя", 120);
        Product product3 = new DiscountedProduct("Бумага для принтера А4", 700, 20);
        Product product4 = new FixPriceProduct("Ручка шариковая синяя");
        Product product5 = new SimpleProduct("Линейка металлическая", 30);
        Product product6 = new FixPriceProduct("Карандаш графитовый");
        Product product7 = new DiscountedProduct("Дырокол", 500, 15);

        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product4);
        basket1.addProduct(product6);
        basket1.addProduct(product7);
        basket2.addProduct(product3);
        basket2.addProduct(product7);

        printSeparator();
        basket1.addProduct(product5);
        printSeparator();

        System.out.println("Содержимое корзины #1:");
        basket1.printProducts();
        printSeparator();

        System.out.println("Общая стоимость корзины #1: " + basket1.totalCost() + " р.");
        printSeparator();

        System.out.println("Поиск в корзине #1 товара " + "\"" + product1.getName() + "\" ...");
        if (basket1.containsProductByName(product1.getName())) {
            System.out.println("Товар найден");
        } else
            System.out.println("Товар не найден");
        printSeparator();

        System.out.println("Поиск в корзине #1 товара " + "\"" + product3.getName() + "\" ...");
        if (basket1.containsProductByName(product3.getName())) {
            System.out.println("Товар найден");
        } else
            System.out.println("Товар не найден");
        printSeparator();

        basket1.clearBasket();
        System.out.println("Корзина #1 очищена!");
        printSeparator();

        System.out.println("Содержимое корзины #1:");
        basket1.printProducts();
        printSeparator();

        System.out.println("Стоимость пустой корзины #1: " + basket1.totalCost() + " р.");
        printSeparator();

        System.out.println("Поиск в корзине #1 товара " + "\"" + product7.getName() + "\" ...");
        if (basket1.containsProductByName(product7.getName())) {
            System.out.println("Товар найден");
        } else
            System.out.println("Товар не найден");
        printSeparator();

        System.out.println("Содержимое корзины #2:");
        basket2.printProducts();
        printSeparator();

        // тест использования класса Article
        Article article = new Article("Распродажа", "Черная пятница всю неделю!");
        System.out.println(article);
        printSeparator();

        // тест использования интерфейса Searchable
        Searchable product = new FixPriceProduct("Ручка шариковая синяя");
        Searchable article2 = new Article("Распродажа шариковых ручек", "На этой неделе все товары из категории " +
                "шариковых ручк продаются по специальной цене!");

        System.out.println(product.getStringRepresentation());
        System.out.println(article.getStringRepresentation());

        System.out.println("Поисковый запрос для товаров: " + product.getSearchTerm());
        System.out.println("Тип товара: " + product.getContentType());

        System.out.println("Поисковый запрос для статей: " + article2.getSearchTerm());
        System.out.println("Тип статьи: " + article2.getContentType());
        printSeparator();
    }
}


