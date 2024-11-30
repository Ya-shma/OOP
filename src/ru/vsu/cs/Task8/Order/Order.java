package ru.vsu.cs.Task8.Order;

import java.util.Objects;

public class Order {
    private Integer idNumber = 0;
    private String customer;
    private OrderStatus orderStatus;
    private final OrderStatus defaultStatus;
    private static int counter;

    public Order(String customer, OrderStatus orderStatus) {
        this.idNumber += counter;
        this.customer = customer;
        this.orderStatus = orderStatus != null ? orderStatus : defaultStatus;
        counter++;
    }

    {
        defaultStatus = OrderStatus.NEW;
    }

    static {
        counter = 7;
    }

    public void changeStatus() {
        if (orderStatus == OrderStatus.NEW) {
            setOrderStatus(OrderStatus.HOLD);
        } else if (orderStatus == OrderStatus.HOLD) {
            setOrderStatus(OrderStatus.SHIPPED);
        } else if (orderStatus == OrderStatus.SHIPPED) {
            setOrderStatus(OrderStatus.DELIVERED);
        } else {
            setOrderStatus(OrderStatus.CLOSED);
        }
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(idNumber, order.idNumber) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idNumber=" + idNumber +
                ", customer='" + customer + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public void validateOrder() throws OrderException {
        if (customer == null || counter < 0) {
            throw new OrderException("Некорректные данные заказа:", this);
        }
    }
}
