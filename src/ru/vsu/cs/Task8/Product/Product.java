package ru.vsu.cs.Task8.Product;

import ru.vsu.cs.Task8.Discount.DiscountTypes;

import java.util.Objects;

public class Product implements StockManager {
    private String nameOfProduct;
    private final String defaultName;
    private Double price;
    private Double defaultPrice = 0.0;
    private String supplier;
    private double tax;
    private static final double PROCENT = 0.13;
    private int stock;

    {
        String instanceMessage = "Экземплярный блок инициализации вызван.";
        defaultName = "Товар";
        System.out.println(instanceMessage);
    }

    static {
        String staticMessage = "Статический блок инициализации вызван.";
        System.out.println(staticMessage);
    }

    public Product(String nameOfProduct, Double price, String supplier) {
        this.nameOfProduct = nameOfProduct != null ? nameOfProduct : defaultName;
        this.price = price != null ? price : defaultPrice;
        this.tax = price * PROCENT;
        this.supplier = supplier;
        this.stock = 0;
    }

    public String priceIncrease(int x) {
        price *= x;
        return "Цена увеличилась в " + x + " раз(а)!";
    }

    @Override
    public void addStock(int quantity) {
        stock += quantity;
    }

    @Override
    public void removeStock(int quantity) throws InsufficientStockException {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            throw new InsufficientStockException("Недостаточно товара на складе!");
        }
    }

    @Override
    public int getStock() {
        return stock;
    }

    public String nameOutput() {
        return "Это продукт:)";
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public Double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameOfProduct, product.nameOfProduct) && Objects.equals(price, product.price) && Objects.equals(supplier, product.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, price, supplier);
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", tax=" + tax +
                '}';
    }

    public double applyDiscount(DiscountTypes discountType, double discountValue) {
        return discountType.value().applyDiscount(price, discountValue);
    }
}
