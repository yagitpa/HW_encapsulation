package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count >= products.length) {
            System.out.println("Корзина переполнена. Невозможно добавить товар");
            return;
        }
        products[count++] = product;
    }

    public int totalCost() {
        int sum = 0;
        for (Product p : products) {
            if (p != null) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printProducts() {
        boolean isEmpty = true;
        int specialProductCount = 0;
        for (Product p : products) {
            if (p != null) {
                System.out.println(p);
                isEmpty = false;
            }
            if (p != null && p.isSpecial()) {
                specialProductCount++;
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
        for (Product p : products) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
