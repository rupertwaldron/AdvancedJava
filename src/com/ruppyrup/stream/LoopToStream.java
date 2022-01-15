package com.ruppyrup.stream;

import java.util.Arrays;
import java.util.function.Predicate;

/**
   Order existingOrder = null;
    Order[] ordersInActiveStatus = orderService.findOrdersByStatus(userId, PAYMENT_RECEIVED);
OUTER: for (int i = 0; i <ordersInActiveStatus.length; i++) {
        Product[] products = ordersInActiveStatus[i].getProducts();
        for (int j = 0; j < products.length; j++) {
        if (products[j] instanceof SimActivation) {
        SimActivation simActivation = (SimActivation) products[j];
        if (ssn.equals(simActivation.getSsn()) && "74".equals(simActivation.getProductId())) {
        existingOrder = ordersInActiveStatus[i];
        break OUTER;
        }
        }
        if (products[j] instanceof SimActivation && products[j].getProductId().equals("74")) {
        existingOrder = ordersInActiveStatus[i];
        }
        }
        }
**/


public class LoopToStream {
    public static void main(String[] args) {
        Product p1 = new Product("74");
        Product p2 = new Product("76");
        Product p3 = new Product("75");
        Product s1 = new SimActivation("74", "1001");
        Product s2 = new SimActivation("74", "1002");
        Product s3 = new SimActivation("75", "1003");
        Product s4 = new SimActivation("78", "1004");


        Order o1 = new Order(new Product[]{p1, p3, s3});
        Order o2 = new Order(new Product[]{p2, s1, s2, s4});
        Order o3 = new Order(new Product[]{s4, p2, p3, s2});

        Order[] orders = new Order[]{o3, o1, o2};

        System.out.println(findMatchingOrderWithLoop(orders, "1001", "74"));
        System.out.println(findMatchingOrderWithStream(orders, "1001", "74"));

    }

    public static Order findMatchingOrderWithStream(Order[] orders, String ssn, String productId) {
        Predicate<SimActivation> simActivationProductForCurrentSim = simActivation -> ssn.equals(simActivation.getSsn()) &&
                productId.equals(simActivation.getProductId());
        return Arrays.stream(orders)
                .filter(order -> Arrays.stream(order.getProducts())
                        .filter(SimActivation.class::isInstance)
                        .map(SimActivation.class::cast)
                        .anyMatch(simActivationProductForCurrentSim))
                .findFirst()
                .orElse(null);
    }

    public static Order findMatchingOrderWithLoop(Order[] orders, String ssn, String productId) {
        Order existingOrder = null;
        OUTER: for (int i = 0; i <orders.length; i++) {
            Product[] products = orders[i].getProducts();
            for (int j = 0; j < products.length; j++) {
                if (products[j] instanceof SimActivation) {
                    SimActivation simActivation = (SimActivation) products[j];
                    if (ssn.equals(simActivation.getSsn()) && productId.equals(simActivation.getProductId())) {
                        existingOrder = orders[i];
                        break OUTER;
                    }
                }
            }
        }
        return existingOrder;
    }
}

class Order {
    private Product[] products;

    public Order(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}


class Product {
    private String productId;

    public Product(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                '}';
    }
}

class SimActivation extends Product {
    private String ssn;

    public SimActivation(String productId, String ssn) {
        super(productId);
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "SimActivation{" +
                "ssn='" + ssn + '\'' +
                "productId=" + getProductId() +  '\'' +
                '}';
    }
}




