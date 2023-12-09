package org.example.currencyConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BBConvertCurrencyTest {

    @Test
    void testConvertValidAmount() {
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        Double expected = 150.0;

        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(expected, result);
    }

    @Test
    void testConvertZeroAmount() {
        Double result = Currency.convert(0.0, 1.5);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertNegativeAmount() {
        Double result = Currency.convert(-100.0, 1.5);
        assertNotEquals(-150.0, result);
    }

    @Test
    void testConvertWithZeroExchangeValue() {
        Double result = Currency.convert(100.0, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithNegativeExchangeValue() {
        Double result = Currency.convert(100.0, -1.5);
        assertNotEquals(-150.0, result);
    }

    @Test
    void testConvertWithVerySmallAmount() {
        Double result = Currency.convert(0.01, 1.5);
        assertEquals(0.02, result);
    }

    @Test
    void testConvertWithVeryLargeAmount() {
        Double result = Currency.convert(1000000.0, 1.5);
        assertEquals(1500000.0, result);
    }

    @Test
    void testConvertWithVerySmallExchangeValue() {
        Double result = Currency.convert(100.0, 0.01);
        assertEquals(1.0, result);
    }

    @Test
    void testConvertWithVeryLargeExchangeValue() {
        Double result = Currency.convert(100.0, 100.0);
        assertEquals(10000.0, result);
    }

    @Test
    void testConvertWithPreciseExchangeValue() {
        Double result = Currency.convert(100.0, 1.234567);
        assertEquals(123.46, result);
    }
}
