package test;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestMainWindow {

    @Test
    public void testValidConversion() {
        ArrayList<Currency> currencies = Currency.init();
        double amount = 100.0;
        double expected = 93.0; // Supposons que c'est le résultat attendu pour USD vers EUR avec 100 USD
        double result = MainWindow.convert("US Dollar", "Euro", currencies, amount);
        assertEquals(expected, result, 0.01, "La conversion de USD vers EUR avec 100 USD devrait être 93 EUR");
    }

    @Test
    public void testInvalidCurrency() {
        ArrayList<Currency> currencies = Currency.init();
        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("InvalidCurrency", "Euro", currencies, 100.0);
        }, "Devrait lancer une IllegalArgumentException pour une devise non valide");
    }

    @Test
    public void testAmountOutOfRange() {
        ArrayList<Currency> currencies = Currency.init();
        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("US Dollar", "Euro", currencies, -100.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant négatif");

        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("US Dollar", "Euro", currencies, 1000001.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant supérieur à 1000000");
    }
}