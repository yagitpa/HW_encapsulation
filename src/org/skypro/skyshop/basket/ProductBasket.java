package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int totalCost() {
        int sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
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

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public void clearBasket() {
        products.clear();
    }
}
