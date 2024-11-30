package ru.vsu.cs.Task8.Discount;
@FunctionalInterface
public interface DiscountStrategy {
    double applyDiscount(double originalPrice, double discountValue);
}