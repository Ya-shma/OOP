package ru.vsu.cs.Task8.Product;
@FunctionalInterface
public interface PriceCalculator {
    double calculateFinalPrice(double price, double taxRate, double discount);
}

