package Task_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConverterTest {
    private static final double DELTA = 0.001;

    @Test
    public void testUsdToOtherCurrencies() {
        // USD to other currencies
        assertEquals(108.0, CurrencyConverter.usdToEur(100), DELTA);
        assertEquals(127.0, CurrencyConverter.usdToGbp(100), DELTA);
        assertEquals(14925.37, CurrencyConverter.usdToJpy(100), DELTA);
    }

    @Test
    public void testEurToOtherCurrencies() {
        // EUR to other currencies
        assertEquals(92.59, CurrencyConverter.eurToUsd(100), DELTA);
        assertEquals(117.59, CurrencyConverter.eurToGbp(100), DELTA);
        assertEquals(13819.4, CurrencyConverter.eurToJpy(100), DELTA);
    }

    @Test
    public void testGbpToOtherCurrencies() {
        // GBP to other currencies
        assertEquals(78.74, CurrencyConverter.gbpToUsd(100), DELTA);
        assertEquals(85.04, CurrencyConverter.gbpToEur(100), DELTA);
        assertEquals(11752.24, CurrencyConverter.gbpToJpy(100), DELTA);
    }

    @Test
    public void testJpyToOtherCurrencies() {
        // JPY to other currencies
        assertEquals(0.67, CurrencyConverter.jpyToUsd(100), DELTA);
        assertEquals(0.72, CurrencyConverter.jpyToEur(100), DELTA);
        assertEquals(0.85, CurrencyConverter.jpyToGbp(100), DELTA);
    }

    @Test
    public void testDirectConversion() {
        // Test direct conversion between any currencies
        assertEquals(108.0, CurrencyConverter.convert(100, "USD", "EUR"), DELTA);
        assertEquals(127.0, CurrencyConverter.convert(100, "USD", "GBP"), DELTA);
        assertEquals(14925.37, CurrencyConverter.convert(100, "USD", "JPY"), DELTA);
        
        assertEquals(92.59, CurrencyConverter.convert(100, "EUR", "USD"), DELTA);
        assertEquals(117.59, CurrencyConverter.convert(100, "EUR", "GBP"), DELTA);
        assertEquals(13819.4, CurrencyConverter.convert(100, "EUR", "JPY"), DELTA);
        
        assertEquals(78.74, CurrencyConverter.convert(100, "GBP", "USD"), DELTA);
        assertEquals(85.04, CurrencyConverter.convert(100, "GBP", "EUR"), DELTA);
        assertEquals(11752.24, CurrencyConverter.convert(100, "GBP", "JPY"), DELTA);
        
        assertEquals(0.67, CurrencyConverter.convert(100, "JPY", "USD"), DELTA);
        assertEquals(0.72, CurrencyConverter.convert(100, "JPY", "EUR"), DELTA);
        assertEquals(0.85, CurrencyConverter.convert(100, "JPY", "GBP"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmount() {
        CurrencyConverter.convert(-100, "USD", "EUR");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFromCurrency() {
        CurrencyConverter.convert(100, null, "EUR");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullToCurrency() {
        CurrencyConverter.convert(100, "USD", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCurrency() {
        CurrencyConverter.convert(100, "USD", "INVALID");
    }

    @Test
    public void testSameCurrencyConversion() {
        assertEquals(100.0, CurrencyConverter.convert(100, "USD", "USD"), DELTA);
        assertEquals(100.0, CurrencyConverter.convert(100, "EUR", "EUR"), DELTA);
        assertEquals(100.0, CurrencyConverter.convert(100, "GBP", "GBP"), DELTA);
        assertEquals(100.0, CurrencyConverter.convert(100, "JPY", "JPY"), DELTA);
    }

    @Test
    public void testZeroAmount() {
        assertEquals(0.0, CurrencyConverter.convert(0, "USD", "EUR"), DELTA);
    }

    @Test
    public void testCaseInsensitiveCurrencyCodes() {
        assertEquals(108.0, CurrencyConverter.convert(100, "usd", "eur"), DELTA);
        assertEquals(108.0, CurrencyConverter.convert(100, "USD", "eur"), DELTA);
        assertEquals(108.0, CurrencyConverter.convert(100, "usd", "EUR"), DELTA);
    }
}
