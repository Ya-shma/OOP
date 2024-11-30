package ru.vsu.cs.Task8.Product;
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}