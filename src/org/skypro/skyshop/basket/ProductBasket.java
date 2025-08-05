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
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printProducts() {
        boolean isEmpty = true;
        int specialProductCount = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    isEmpty = false;
                }
                if (product != null && product.isSpecial()) {
                    specialProductCount++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("ИТОГО: " + totalCost() + " р.");
            System.out.println("Специальных товаров: " + specialProductCount);
        }
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
