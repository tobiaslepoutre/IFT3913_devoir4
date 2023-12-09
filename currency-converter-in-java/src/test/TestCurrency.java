package test;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

public class TestCurrency {

    @Test
    public void testValidConversion() {
        Assert.assertEquals("Une conversion normalement valide a échouée", 131.0, Currency.convert(100.0, 1.31), 0.01);
    }
    
    @Test
    public void testValidConversionUSD() {
        Double amountUSD = 100.0; // Montant en USD.

        // Conversion USD vers CAD (Estimation)
        assertEquals(125.0, Currency.convert(amountUSD, 1.25));

        // Conversion USD vers GBP
        assertEquals(66.0, Currency.convert(amountUSD, 0.66));
        
        // Conversion USD vers EUR
        assertEquals(93.0, Currency.convert(amountUSD, 0.93));

        // Conversion USD vers CHF
        assertEquals(101.0, Currency.convert(amountUSD, 1.01));

        // Conversion USD vers AUD (Estimation)
        assertEquals(140.0, Currency.convert(amountUSD, 1.40));
    }
    
    @Test
    public void testValidConversionCAD() {
        Double amountCAD = 100.0; // Montant en CAD

        // Conversion CAD vers USD (Estimation)
        assertEquals(80.0, Currency.convert(amountCAD, 0.80));

        // Conversion CAD vers GBP (Estimation)
        assertEquals(53.2, Currency.convert(amountCAD, 0.532));
        
        // Conversion CAD vers EUR (Estimation)
        assertEquals(70.4, Currency.convert(amountCAD, 0.704));

        // Conversion CAD vers CHF (Estimation)
        assertEquals(80.8, Currency.convert(amountCAD, 0.808));

        // Conversion CAD vers AUD (Estimation)
        assertEquals(112.0, Currency.convert(amountCAD, 1.12));
    }
    
    @Test
    public void testValidConversionGBP() {
        Double amountGBP = 100.0; // Montant en GBP

        // Conversion GBP vers USD
        assertEquals(151.0, Currency.convert(amountGBP, 1.51));

        // Conversion GBP vers CAD (Estimation)
        assertEquals(189.4, Currency.convert(amountGBP, 1.894));

        // Conversion GBP vers EUR
        assertEquals(141.0, Currency.convert(amountGBP, 1.41));
        
        // Conversion GBP vers CHF
        assertEquals(152.0, Currency.convert(amountGBP, 1.52));

        // Conversion GBP vers AUD (Estimation)
        assertEquals(224.0, Currency.convert(amountGBP, 2.24));
    }
    
    @Test
    public void testValidConversionEUR() {
        Double amountEUR = 100.0; // Montant en EUR.

        // Conversion EUR vers USD
        assertEquals(107.3, Currency.convert(amountEUR, 1.073));

        // Conversion EUR vers GBP
        assertEquals(71.0, Currency.convert(amountEUR, 0.71));
        
        // Conversion EUR vers CAD (Estimation)
        assertEquals(117.3, Currency.convert(amountEUR, 1.173)); 
        
        // Conversion EUR vers CHF
        assertEquals(108.0, Currency.convert(amountEUR, 1.08));

        // Conversion EUR vers AUD (Estimation)
        assertEquals(155.6, Currency.convert(amountEUR, 1.556));
    }
    
    @Test
    public void testValidConversionCHF() {
        Double amountCHF = 100.0; // Montant en CHF

        // Conversion CHF vers USD
        assertEquals(99.0, Currency.convert(amountCHF, 0.99), 0.01);

        // Conversion CHF vers GBP
        assertEquals(66.0, Currency.convert(amountCHF, 0.66), 0.01);

        // Conversion CHF vers EUR
        assertEquals(93.0, Currency.convert(amountCHF, 0.93), 0.01);

        // Conversion CHF vers CAD (Estimation)
        assertEquals(126.3, Currency.convert(amountCHF, 1.263), 0.01);

        // Conversion CHF vers AUD (Estimation)
        assertEquals(144.4, Currency.convert(amountCHF, 1.444), 0.01);
    }
    

    @Test
    public void testValidConversionAUD() {
        Double amountAUD = 100.0; // Montant en AUD

        // Conversion AUD vers USD (Estimation)
        assertEquals(71.4, Currency.convert(amountAUD, 0.714), 0.01);

        // Conversion AUD vers GBP (Estimation)
        assertEquals(44.6, Currency.convert(amountAUD, 0.446), 0.01);

        // Conversion AUD vers EUR (Estimation)
        assertEquals(64.3, Currency.convert(amountAUD, 0.643), 0.01);

        // Conversion AUD vers CAD (Estimation)
        assertEquals(84.5, Currency.convert(amountAUD, 0.845), 0.01);

        // Conversion AUD vers CHF (Estimation)
        assertEquals(69.4, Currency.convert(amountAUD, 0.694), 0.01);
    }
    
    @Test
    public void testNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(-100.0, 1.0);
        }, "Devrait lancer une IllegalArgumentException pour un montant négatif");
    }
    
    @Test
    public void testZeroAmount() {
        assertEquals(0, Currency.convert(0.0, 1.0), 0.01, "La conversion d'un montant de 0 devrait toujours être 0");
    }
    
    @Test
    public void testExcessiveAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(1000001.0, 1.0); // Amount above 1,000,000
        }, "Devrait lancer une IllegalArgumentException pour un montant excessif");
    }

    @Test
    public void testInvalidExchangeRateNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(100.0, -1.0); // Taux de change négatif
        }, "Devrait lancer une IllegalArgumentException pour un taux de change négatif");
    }

    @Test
    public void testInvalidExchangeRateZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency.convert(100.0, 0.0); // Taux de change nul
        }, "Devrait lancer une IllegalArgumentException pour un taux de change nul");
    }
}
