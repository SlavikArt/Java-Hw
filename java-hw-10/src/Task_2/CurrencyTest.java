package Task_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyTest {
    @Test
    public void testDollarConversion() {
        Dollar dollar = new Dollar(100);
        assertEquals(100.0, dollar.convertToDollars(), 0.001);
        assertEquals(100.0, dollar.convertFromDollars(100.0), 0.001);
    }

    @Test
    public void testEuroConversion() {
        Euro euro = new Euro(100);
        assertEquals(108.0, euro.convertToDollars(), 0.001);
        assertEquals(92.59, euro.convertFromDollars(100.0), 0.001);
    }

    @Test
    public void testPoundConversion() {
        Pound pound = new Pound(100);
        assertEquals(127.0, pound.convertToDollars(), 0.001);
        assertEquals(78.74, pound.convertFromDollars(100.0), 0.001);
    }

    @Test
    public void testYenConversion() {
        Yen yen = new Yen(10000);
        assertEquals(67.0, yen.convertToDollars(), 0.001);
        assertEquals(14925.37, yen.convertFromDollars(100.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDollar() {
        new Dollar(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeEuro() {
        new Euro(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePound() {
        new Pound(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeYen() {
        new Yen(-1);
    }
}
