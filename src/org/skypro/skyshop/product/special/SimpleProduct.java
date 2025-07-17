package org.skypro.skyshop.product.special;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class SimpleProduct extends Product {

    private double price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена товара должна быть строго больше нуля!");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Товар: " + getName() + ", Цена: " + price + " р.";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
