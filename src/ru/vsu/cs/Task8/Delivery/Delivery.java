package ru.vsu.cs.Task8.Delivery;

import ru.vsu.cs.Task8.Order.Order;
import ru.vsu.cs.Task8.Product.Product;

import java.util.List;
import java.util.Objects;

public class Delivery {
    private Order order;
    private List<Product> products;
    private String address;
    private Double totalPrice = 0.0;

    public Delivery(Order order, List<Product> products, String address) {
        this.order = order;
        this.products = products;
        this.address = address;
    }

    public void changeAddress(String newAddress) {
        if (newAddress == null || newAddress.isEmpty()) {
            return;
        }
        setAddress(newAddress);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(order, delivery.order) && Objects.equals(products, delivery.products) && Objects.equals(address, delivery.address) && Objects.equals(totalPrice, delivery.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, products, address, totalPrice);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "order=" + order +
                ", products=" + products +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public void validateDelivery() throws DeliveryException {
        if (address == null || address.isEmpty()) {
            throw new DeliveryException("Некорректные данные доставки:", this);
        }
    }
}