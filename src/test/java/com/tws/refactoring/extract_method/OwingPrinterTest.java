package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<Order> orderList = new ArrayList<>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_return_receipt_when_given_name_and_order() {
        OwingPrinter owingPrinter = new OwingPrinter();
        String expectedResult = "*****************************\r\n"+
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: Coke\r\n"+
                "amount: 10.0\r\n";
        Order order = new Order(10);
        orderList.add(order);

        owingPrinter.printOwing("Coke", orderList);

        assertEquals(expectedResult , outContent.toString());
    }
}