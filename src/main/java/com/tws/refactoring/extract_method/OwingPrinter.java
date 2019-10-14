package com.tws.refactoring.extract_method;

import java.util.Iterator;
import java.util.List;

public class OwingPrinter {
    public void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();

        String printReceipt = printBanner();
        Double outstanding = printOwings(elements);
        String printDetails = "name: " + name + "\r\n" +
                "amount: " + outstanding;

        System.out.println(printReceipt + printDetails);
    }

    public String printBanner() {
        return "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n";
    }

    public Double printOwings(Iterator<Order> elements) {
        Double outstanding = 0.0;
        while (elements.hasNext()) {
            Order each = elements.next();
            outstanding += each.getAmount();
        }

        return outstanding;
    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
