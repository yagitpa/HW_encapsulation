package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.special.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.List;

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

        try {
            Product product20 = new SimpleProduct("", 15);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product21 = new SimpleProduct("Корзина для бумаг", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product22 = new DiscountedProduct("Скобы", 150, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product23 = new DiscountedProduct("Скобы", 0, 15);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product4);
        basket1.addProduct(product6);
        basket1.addProduct(product7);
        basket2.addProduct(product3);
        basket2.addProduct(product7);

        printSeparator();
        System.out.println("Содержимое корзины #1 (ДО удаления по наименованию товара):");
        basket1.printProducts();
        printSeparator();

        System.out.println("Общая стоимость корзины #1: " + basket1.totalCost() + " р.");
        printSeparator();

        List<Product> removedProducts = basket1.removeProductByName("Яблоко");

        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных товаров пуст!");
        } else
            System.out.println("Список удаленных продуктов из корзины №1:");
            for (Product product : removedProducts) {
                System.out.println(product.getName() + ": " + product.getPrice());
        }

        System.out.println();
        System.out.println("Содержимое корзины №1 (ПОСЛЕ удаления по наименованию товара):");
        basket1.printProducts();

        System.out.println();
        System.out.println("Общая стоимость корзины #1 после удаления: " + basket1.totalCost() + " р.");
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

        SearchEngine engine = new SearchEngine();

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
        List<Searchable> results = engine.search("СТеПЛЕР");
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }

        try {
            Searchable bestResult = engine.findBestResult("кресло");
            System.out.println("Подходящий результат по Вашему запросу найден:\n" + bestResult.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            Searchable bestResult = engine.findBestResult("часы");
            System.out.println("Подходящий результат по Вашему запросу найден:\n" + bestResult.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }
        printSeparator();
    }
}


