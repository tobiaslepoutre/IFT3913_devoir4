package org.example.currencyConverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class BBConvertMainWindowTest {

    private ArrayList<Currency> currencies;

    @BeforeEach
    void setUp() {
        currencies = Currency.init();
    }

    @Test
    void testConvertWithValidCurrencies() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    void testConvertWithInvalidSourceCurrency() {
        Double result = MainWindow.convert("Invalid Currency", "Euro", currencies, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithInvalidTargetCurrency() {
        Double result = MainWindow.convert("US Dollar", "Invalid Currency", currencies, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithNullCurrenciesList() {
        Double result = MainWindow.convert("US Dollar", "Euro", null, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithEmptyCurrenciesList() {
        Double result = MainWindow.convert("US Dollar", "Euro", new ArrayList<>(), 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithZeroAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 0.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithNegativeAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, -100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithSameSourceAndTargetCurrency() {
        Double result = MainWindow.convert("US Dollar", "US Dollar", currencies, 100.0);
        assertEquals(100.0, result);
    }

    @Test
    void testConvertWithNonExistentExchangeValue() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);
        assertNotNull(result);
    }

    @Test
    void testConvertWithLargeAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 1000000.0);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    void testConvertWithVerySmallAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 0.01);
        assertNotNull(result);
        assertTrue(result >= 0);
    }

    @Test
    void testConvertCurrencyNotFoundInFirstLoop() {
        Double result = MainWindow.convert("Invalid Currency", "Euro", currencies, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertCurrencyNotFoundInSecondLoop() {
        Double result = MainWindow.convert("US Dollar", "Invalid Currency", currencies, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithNullAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, null);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithReversedCurrencies() {
        Double result = MainWindow.convert("Euro", "US Dollar", currencies, 100.0);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    void testConvertWithInvalidCurrencies() {
        Double result = MainWindow.convert("Invalid Currency 1", "Invalid Currency 2", currencies, 100.0);
        assertEquals(0.0, result);
    }

    @Test
    void testConvertWithMinimalAmount() {
        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 0.001);
        assertTrue(result >= 0);
    }

    @Test
    void testConvertVariousValidCombinations() {
        Double result1 = MainWindow.convert("British Pound", "Japanese Yen", currencies, 50.0);
        Double result2 = MainWindow.convert("Swiss Franc", "Chinese Yuan Renminbi", currencies, 200.0);
        assertNotNull(result1);
        assertTrue(result1 > 0);
        assertNotNull(result2);
        assertTrue(result2 > 0);
    }

    @Test
    void testConvertWithModifiedCurrencyList() {
        Currency newCurrency = new Currency("Test Currency", "TST");
        newCurrency.setExchangeValues("USD", 2.0);
        currencies.add(newCurrency);
        Double result = MainWindow.convert("Test Currency", "US Dollar", currencies, 100.0);
        assertEquals(200.0, result);
    }


}

