package ru.vsu.cs.Task8.Product;

public interface StockManager {
    void addStock(int quantity);

    void removeStock(int quantity) throws InsufficientStockException;

    int getStock();
}

