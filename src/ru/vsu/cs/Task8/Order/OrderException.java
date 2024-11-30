package ru.vsu.cs.Task8.Order;

import ru.vsu.cs.Task8.Order.Order;

public class OrderException extends Exception {
    public OrderException(String message, Order order) {
        super(message + " Order ID: " + order.getIdNumber() + ", Customer: " + order.getCustomer());
    }
}
