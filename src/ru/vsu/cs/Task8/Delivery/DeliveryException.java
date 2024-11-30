package ru.vsu.cs.Task8.Delivery;

import ru.vsu.cs.Task8.Delivery.Delivery;

public class DeliveryException extends Exception {
    public DeliveryException(String message, Delivery delivery) {
        super(message + " Order ID: " + delivery.getOrder().getIdNumber() + ", Delivery to: " + delivery.getAddress());
    }
}