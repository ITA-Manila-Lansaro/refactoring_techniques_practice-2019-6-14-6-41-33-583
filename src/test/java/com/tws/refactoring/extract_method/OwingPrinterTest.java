package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.BannerRender;
import com.tws.refactoring.extract_variable.PriceCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
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

    @Test
    public void should_return_total_when_get_price_calculates_itemPrice_and_quantity() {
        int quantity = 10;
        int itemprice = 15;
        PriceCalculator priceCalculator = new PriceCalculator();

        assertThat(priceCalculator.getPrice(quantity, itemprice), is(165.0));
    }

    @Test
    public void should_return_IT_on_Mac_when_input_has_MAC_or_IE() {
        BannerRender bannerRender = new BannerRender();
        assertThat(bannerRender.renderBanner("MAC", "IE"), is("IE on Mac?"));
    }
}