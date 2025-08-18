package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public double totalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printProducts() {
        int specialProductCount = getSpecialCount();

        products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("ИТОГО: " + totalCost() + " р.");
            System.out.println("Специальных товаров: " + specialProductCount);
        }
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }

    public void clearBasket() {
        products.clear();
    }
}

