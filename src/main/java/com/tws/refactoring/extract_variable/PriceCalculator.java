package com.tws.refactoring.extract_variable;

public class                                                                                                                    PriceCalculator {
    double getPrice(int quantity, int itemPrice) {
        return calculateBasePrice(quantity, itemPrice) -
                calculateDiscount(quantity) +
                calculateShippingCost(quantity, itemPrice);
    }

    private int calculateBasePrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }

    private int calculateShippingCost(int quantity, int itemPrice) {
        return (int) Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    private int calculateDiscount(int quantity) {
        return Math.max(0, quantity - 500);
    }
}
