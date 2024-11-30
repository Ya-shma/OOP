package ru.vsu.cs.Task8;

import ru.vsu.cs.Task8.Delivery.Delivery;
import ru.vsu.cs.Task8.Delivery.DeliveryException;
import ru.vsu.cs.Task8.Discount.DiscountTypes;
import ru.vsu.cs.Task8.Order.Order;
import ru.vsu.cs.Task8.Order.OrderException;
import ru.vsu.cs.Task8.Order.OrderStatus;
import ru.vsu.cs.Task8.Product.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task1_4();
        Task_EqualsHashcode();
        Task_Interfaces();
        Task_EnumException();
    }

    public static void Task1_4() {
        List<Product> productList = new ArrayList<>();
        Product product = new Product("Соус", 150.2, "Heinz");
        System.out.println(product.priceIncrease(3));
        System.out.println(product.getPrice());
        Product x = new Product(null, 123.1, "ИП Домодедово");
        System.out.println(x);
        System.out.println("-------------------------------------------------------------------------------------------");
        Bread bread1 = new Bread("Harry's", 96.5, "ООО Хлебзавод", "мультизерновой");
        Bread bread2 = new Bread(null, 100.0, "ИП Петров", null);
        System.out.println(bread1);
        System.out.println(bread2);
        System.out.println("-------------------------------------------------------------------------------------------");
        Milk milk1 = new Milk("Лебедянь", 48.6, "ОАО Молокоград", 4.5);
        Milk milk2 = new Milk(null, 324.3, "ООО Вкуснотеево", null);
        System.out.println(milk1);
        System.out.println(milk1.checkFatness());
        System.out.println(milk2);
        System.out.println("-------------------------------------------------------------------------------------------");
        Order order = new Order("Иванов Иван", null);
        System.out.println(order.getOrderStatus());
        order.changeStatus();
        System.out.println(order.getOrderStatus());
        System.out.println("-------------------------------------------------------------------------------------------");
        productList.add(bread1);
        productList.add(milk2);
        System.out.println(productList);
        Delivery delivery = new Delivery(order, productList, "Село Любятово");
        System.out.println(delivery);
        delivery.changeAddress("Бабяково");
        System.out.println(delivery.getAddress());
        System.out.println("-------------------------------------------------------------------------------------------");
        Product[] products = new Product[2];
        products[0] = new Milk("Молоко", 50.0, "Молочный завод", 3.5);
        products[1] = new Bread("Хлеб", 30.0, "Хлебозавод", "Ржаной");
        System.out.println(product.nameOutput());
        for (Product p : products) {
            System.out.println(p.nameOutput());
        }
    }

    public static void Task_EqualsHashcode() {
        System.out.println("------------------------------------Task_EqualsHashcode---------------------------------------");

        Product product1 = new Product("Apple", 1.0, "Supplier A");
        Product product2 = new Product("Banana", 0.5, "Supplier B");
        Product product3 = new Product("Apple", 1.0, "Supplier A");
        System.out.println(product1.equals(product2)); //false
        System.out.println(product1.equals(product3)); //true

        Order order1 = new Order("Customer A", OrderStatus.NEW);
        Order order2 = new Order("Customer B", OrderStatus.HOLD);
        Order order3 = new Order("Customer A", OrderStatus.NEW);
        System.out.println(order1.equals(order2)); //false
        System.out.println(order1.equals(order3)); //false, т.к. ID заказа разные

        Bread bread = new Bread("Bread", 1.5, "Supplier C", "Ржаной");
        Milk milk = new Milk("Milk", 1.2, "Supplier D", 3.0);

        System.out.println("Сравнение хлеба и молока: " + bread.equals(milk)); //false
    }

    public static void Task_Interfaces() {
        System.out.println("-------------------------------------Task_Interfaces------------------------------------------");

        Bread bread = new Bread("Bread", 1.5, "Supplier C", "Ржаной");
        Milk milk = new Milk("Milk", 1.2, "Supplier D", 3.0);

        milk.addStock(10);
        bread.addStock(5);

        System.out.println("Количество молока в запасе: " + milk.getStock());
        System.out.println("Количество хлеба в запасе: " + bread.getStock());

        //здесь я считаю итоговую цену с учетом скидки и налога
        PriceCalculator finalPriceCalculator = (price, taxRate, discount) -> {
            double discountedPrice = price - (price * discount / 100);
            return discountedPrice * (1 + taxRate);
        };

        double taxRate = 0.13;
        double discount = 10.0;

        double priceForMilk = finalPriceCalculator.calculateFinalPrice(milk.getPrice(), taxRate, discount);
        double priceForBread = finalPriceCalculator.calculateFinalPrice(bread.getPrice(), taxRate, discount);

        System.out.println("Итоговая цена для молока: " + priceForMilk);
        System.out.println("Итоговая цена для хлеба: " + priceForBread);
    }

    public static void Task_EnumException() {
        System.out.println("------------------------------------Task_EnumException----------------------------------------");
        Product product = new Product("Test Product", 100.0, "Test Supplier");
        product.addStock(10);

        double percentageDiscountedPrice = product.applyDiscount(DiscountTypes.PERCENTAGE_DISCOUNT, 20);
        double flatDiscountedPrice = product.applyDiscount(DiscountTypes.FIX_DISCOUNT, 15);
        double onePlusOnePrice = product.applyDiscount(DiscountTypes.ONE_PLUS_ONE, 1);

        System.out.println("Цена со скидкой 20%: " + percentageDiscountedPrice);
        System.out.println("Цена со скидкой 15$: " + flatDiscountedPrice);
        System.out.println("Цена по акции 1+1: " + onePlusOnePrice);

        try {
            Order order = new Order(null, null);
            order.validateOrder();
        } catch (OrderException e) {
            System.out.println(e.getMessage());
        }
        try {
            Delivery delivery = new Delivery(new Order("John", OrderStatus.NEW), new ArrayList<>(), "");
            delivery.validateDelivery();
        } catch (DeliveryException e) {
            System.out.println(e.getMessage());
        }

        Product productTest = new Product("Pineapple", 125.7, "PineappleLand");
        productTest.addStock(15);
        try {
            productTest.removeStock(25);
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
