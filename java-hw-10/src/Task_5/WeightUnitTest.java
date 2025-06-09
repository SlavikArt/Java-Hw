package Task_5;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeightUnitTest {
    @Test
    public void testMilligramConversion() {
        Milligram mg = new Milligram(1000000);
        assertEquals(1.0, mg.convertToKilograms(), 0.001);
        assertEquals(1000000.0, mg.convertFromKilograms(1.0), 0.001);
    }

    @Test
    public void testGramConversion() {
        Gram g = new Gram(1000);
        assertEquals(1.0, g.convertToKilograms(), 0.001);
        assertEquals(1000.0, g.convertFromKilograms(1.0), 0.001);
    }

    @Test
    public void testKilogramConversion() {
        Kilogram kg = new Kilogram(1);
        assertEquals(1.0, kg.convertToKilograms(), 0.001);
        assertEquals(1.0, kg.convertFromKilograms(1.0), 0.001);
    }

    @Test
    public void testCentnerConversion() {
        Centner c = new Centner(1);
        assertEquals(100.0, c.convertToKilograms(), 0.001);
        assertEquals(1.0, c.convertFromKilograms(100.0), 0.001);
    }

    @Test
    public void testTonConversion() {
        Ton t = new Ton(1);
        assertEquals(1000.0, t.convertToKilograms(), 0.001);
        assertEquals(1.0, t.convertFromKilograms(1000.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMilligram() {
        new Milligram(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeGram() {
        new Gram(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeKilogram() {
        new Kilogram(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCentner() {
        new Centner(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeTon() {
        new Ton(-1);
    }
} 