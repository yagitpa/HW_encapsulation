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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleProduct that = (SimpleProduct) o;
        return super.equals(o) && price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
