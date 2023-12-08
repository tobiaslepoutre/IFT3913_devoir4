package test;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class TestCurrency {

    @Test
    public void testValidConversion() {
        double amount = 100.0;
        double exchangeRate = 0.93; // Taux de conversion de USD à EUR
        double expected = 93.0; // Résultat attendu pour 100 USD convertis en EUR
        double result = Currency.convert(amount, exchangeRate);
        assertEquals(expected, result, 0.01, "100 USD convertis en EUR devraient être 93 EUR");
    }

    @Test
    public void testZeroAmount() {
        double result = Currency.convert(0.0, 1.0);
        assertEquals(0, result, 0.01, "La conversion d'un montant de 0 devrait toujours être 0");
    }

    @Test
    public void testZeroExchangeRate() {
        double result = Currency.convert(100.0, 0.0);
        assertEquals(0, result, 0.01, "La conversion avec un taux de change de 0 devrait toujours être 0");
    }

    @Test
    public void testNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(-100.0, 1.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant négatif");
    }
}