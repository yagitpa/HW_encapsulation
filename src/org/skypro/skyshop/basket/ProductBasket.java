package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int totalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(product -> (int) product.getPrice())
                .sum();
    }

    public void printProducts() {
        boolean isEmpty = true;
        int specialProductCount = getSpecialCount();

        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> {
                    if (product != null) {
                        System.out.println(product);
                    }
                });
        isEmpty &= !products.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> product != null);

        if (isEmpty) {
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

