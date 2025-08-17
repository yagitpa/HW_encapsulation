package org.skypro.skyshop.product.special;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {

    private double basePrice;
    private int discountWholePercentages;

    public DiscountedProduct(String name, double basePrice, int discountWholePercentages) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена товара должна быть строго больше нуля!");
        }
        if (discountWholePercentages < 0 || discountWholePercentages > 100) {
            throw new IllegalArgumentException("Скидка на товар не может быть меньше 0 и больше 100%");
        }
        this.basePrice = basePrice;
        this.discountWholePercentages = discountWholePercentages;
    }

    @Override
    public double getPrice() {
        return basePrice - (basePrice * discountWholePercentages / 100);
    }

    @Override
    public String toString() {
        return "Товар со скидкой: " + getName() + ", Начальная цена: " + basePrice + " р., Скидка: " + discountWholePercentages +
                "%, Цена со скидкой: " + getPrice() + " р.";
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountedProduct that = (DiscountedProduct) o;
        return super.equals(o) && basePrice == that.basePrice && discountWholePercentages == that.discountWholePercentages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discountWholePercentages);
    }
}



