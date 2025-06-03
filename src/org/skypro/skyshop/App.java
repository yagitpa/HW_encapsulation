package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void printSeparator() {
        System.out.println("======================================================");
    }

    public static void main(String[] args) {

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        Product product1 = new Product("Степлер", 500);
        Product product2 = new Product("Ручка гелевая синяя", 120);
        Product product3 = new Product("Бумага для принтера А4", 700);
        Product product4 = new Product("Ручка шариковая синяя", 55);
        Product product5 = new Product("Линейка металлическая", 30);
        Product product6 = new Product("Карандаш графитовый", 20);
        Product product7 = new Product("Дырокол", 500);

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
    }
}


