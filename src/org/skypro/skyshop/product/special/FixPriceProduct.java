package org.skypro.skyshop.product.special;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class FixPriceProduct extends Product {

    private static final double FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return "Товар по фиксированной цене: " + getName() + ", Цена: " + FIX_PRICE + " р.";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null || getClass() != o.getClass()) {
            return false;
        }
        FixPriceProduct that = (FixPriceProduct) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}

