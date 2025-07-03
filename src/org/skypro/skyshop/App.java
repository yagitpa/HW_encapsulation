package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.special.*;
import org.skypro.skyshop.search.*;

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

        SearchEngine engine = new SearchEngine(10);

        Searchable article1 = new Article("Бумага", "Расширение ассортимента бумаги для принтера");
        Searchable article2 = new Article("Степлеры", "Разнообразие, виды, назначение");
        Searchable article3 = new Article("Кресло руководителя", "Это не просто кресло!");
        Searchable article4 = new Article("Кресло для геймера", "Со специальным антипригарным покрытием!");

        engine.add(product1);
        engine.add(product2);
        engine.add(product3);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);

        System.out.println("Тестирование работы поиска:");
        printSeparator();
        System.out.println("Поиск по слову \"Степлер\":");
        displayResults(engine.search("степлер"));

        System.out.println("Поиск по слову \"Кресло\":");
        displayResults(engine.search("кресло"));

        System.out.println("Поиск по слову \"Бумага\":");
        displayResults(engine.search("Бумага"));

        System.out.println("Поиск по слову \"Мороженое\":");
        displayResults(engine.search("Мороженое"));
        printSeparator();
    }
    private static void displayResults(Searchable[] results) {
        boolean foundAnything = false;
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
                foundAnything = true;
            }
        }
        if (!foundAnything) {
            System.out.println("Ничего не найдено");
        }
    }
}


