package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class BNConvertMainWindowTest {
	public ArrayList<Currency> currencies;
	
	@Before
    public void setUp() {
        currencies = Currency.init();
    }
	
	@Test
    public void testValidConversion() {
        Assert.assertEquals("Une conversion normalement valide a échouée", 930.0, MainWindow.convert("US Dollar", "Euro", currencies, 1000.0), 0.01);
	}

    @Test
    public void testValidConversionUSD() {
        // Conversion USD vers CAD (Estimation)
        assertEquals(125.0, MainWindow.convert("US Dollar", "Canadian Dollar", currencies, 100.0));
        
        // Conversion USD vers GBP
        assertEquals(66.0, MainWindow.convert("US Dollar", "British Pound", currencies, 100.0));
        
        // Conversion USD vers EUR
        assertEquals(93.0, MainWindow.convert("US Dollar", "Euro", currencies, 100.0));

        // Conversion USD vers CHF
        assertEquals(101.0, MainWindow.convert("US Dollar", "Swiss Franc", currencies, 100.0));

        // Conversion USD vers AUD (Estimation)
        assertEquals(140.0, MainWindow.convert("US Dollar", "Australian Dollar", currencies, 100.0)); // Estimation

    }
    
    @Test
    public void testValidConversionCAD() {
        // Conversion CAD vers USD (Estimation)
        assertEquals(80.0, MainWindow.convert("Canadian Dollar", "US Dollar", currencies, 100.0)); 

        // Conversion CAD vers GBP (Estimation)
        assertEquals(53.2, MainWindow.convert("Canadian Dollar", "British Pound", currencies, 100.0)); // Estimation

        // Conversion CAD vers EUR (Estimation)
        assertEquals(70.4, MainWindow.convert("Canadian Dollar", "Euro", currencies, 100.0)); // Estimation

        // Conversion CAD vers CHF (Estimation)
        assertEquals(80.8, MainWindow.convert("Canadian Dollar", "Swiss Franc", currencies, 100.0)); // Estimation

        // Conversion CAD vers AUD (Estimation)
        assertEquals(112.0, MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 100.0)); // Estimation
    }
    
    @Test
    public void testValidConversionGBP() {
        // Conversion GBP vers USD
        assertEquals(151.0, MainWindow.convert("British Pound", "US Dollar", currencies, 100.0)); // 1 GBP = 1.51 USD

        // Conversion GBP vers CAD (Estimation)
        assertEquals(189.4, MainWindow.convert("British Pound", "Canadian Dollar", currencies, 100.0)); // Estimation

        // Conversion GBP vers EUR
        assertEquals(141.0, MainWindow.convert("British Pound", "Euro", currencies, 100.0)); // 1 GBP = 1.41 EUR

        // Conversion GBP vers CHF
        assertEquals(152.0, MainWindow.convert("British Pound", "Swiss Franc", currencies, 100.0)); // 1 GBP = 1.52 CHF

        // Conversion GBP vers AUD (Estimation)
        assertEquals(224.0, MainWindow.convert("British Pound", "Australian Dollar", currencies, 100.0)); // Estimation
    }

    @Test
    public void testValidConversionEUR() {
        // Conversion EUR vers USD
        assertEquals(107.3, MainWindow.convert("Euro", "US Dollar", currencies, 100.0)); // 1 EUR = 1.073 USD

        // Conversion EUR vers GBP
        assertEquals(71.0, MainWindow.convert("Euro", "British Pound", currencies, 100.0)); // 1 EUR = 0.71 GBP

        // Conversion EUR vers CAD (Estimation)
        assertEquals(117.3, MainWindow.convert("Euro", "Canadian Dollar", currencies, 100.0)); // Estimation

        // Conversion EUR vers CHF
        assertEquals(108.0, MainWindow.convert("Euro", "Swiss Franc", currencies, 100.0)); // 1 EUR = 1.08 CHF

        // Conversion EUR vers AUD (Estimation)
        assertEquals(155.6, MainWindow.convert("Euro", "Australian Dollar", currencies, 100.0)); // Estimation
    }
    
    @Test
    public void testValidConversionCHF() {
        // Conversion CHF vers USD
        assertEquals(99.0, MainWindow.convert("Swiss Franc", "US Dollar", currencies, 100.0)); // 1 CHF = 0.99 USD

        // Conversion CHF vers GBP
        assertEquals(66.0, MainWindow.convert("Swiss Franc", "British Pound", currencies, 100.0)); // 1 CHF = 0.66 GBP

        // Conversion CHF vers EUR
        assertEquals(93.0, MainWindow.convert("Swiss Franc", "Euro", currencies, 100.0)); // 1 CHF = 0.93 EUR

        // Conversion CHF vers CAD (Estimation)
        assertEquals(126.3, MainWindow.convert("Swiss Franc", "Canadian Dollar", currencies, 100.0)); // Estimation

        // Conversion CHF vers AUD (Estimation)
        assertEquals(144.4, MainWindow.convert("Swiss Franc", "Australian Dollar", currencies, 100.0)); // Estimation
    }
    
    @Test
    public void testValidConversionAUD() {
        // Conversion AUD vers USD (Estimation)
        assertEquals(71.4, MainWindow.convert("Australian Dollar", "US Dollar", currencies, 100.0)); // Estimation

        // Conversion AUD vers GBP (Estimation)
        assertEquals(44.6, MainWindow.convert("Australian Dollar", "British Pound", currencies, 100.0)); // Estimation

        // Conversion AUD vers EUR (Estimation)
        assertEquals(64.3, MainWindow.convert("Australian Dollar", "Euro", currencies, 100.0)); // Estimation

        // Conversion AUD vers CAD (Estimation)
        assertEquals(84.5, MainWindow.convert("Australian Dollar", "Canadian Dollar", currencies, 100.0)); // Estimation

        // Conversion AUD vers CHF (Estimation)
        assertEquals(69.4, MainWindow.convert("Australian Dollar", "Swiss Franc", currencies, 100.0)); // Estimation
    }

    @Test
    public void testInvalidCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("InvalidCurrency", "Euro", currencies, 100.0);
        }, "Devrait lancer une IllegalArgumentException pour une devise non valide");
    }

    @Test
    public void testAmountOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("US Dollar", "Euro", currencies, -100.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant négatif");

        assertThrows(IllegalArgumentException.class, () -> {
            MainWindow.convert("US Dollar", "Euro", currencies, 1000001.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant supérieur à 1000000");
    }
      
}
