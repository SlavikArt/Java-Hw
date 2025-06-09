package Task_4;

import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {
    @Test
    public void testMillimeterConversion() {
        Millimeter mm = new Millimeter(1000);
        assertEquals(1.0, mm.convertToMeters(), 0.001);
        assertEquals(1000.0, mm.convertFromMeters(1.0), 0.001);
    }

    @Test
    public void testCentimeterConversion() {
        Centimeter cm = new Centimeter(100);
        assertEquals(1.0, cm.convertToMeters(), 0.001);
        assertEquals(100.0, cm.convertFromMeters(1.0), 0.001);
    }

    @Test
    public void testDecimeterConversion() {
        Decimeter dm = new Decimeter(10);
        assertEquals(1.0, dm.convertToMeters(), 0.001);
        assertEquals(10.0, dm.convertFromMeters(1.0), 0.001);
    }

    @Test
    public void testMeterConversion() {
        Meter m = new Meter(1);
        assertEquals(1.0, m.convertToMeters(), 0.001);
        assertEquals(1.0, m.convertFromMeters(1.0), 0.001);
    }

    @Test
    public void testKilometerConversion() {
        Kilometer km = new Kilometer(1);
        assertEquals(1000.0, km.convertToMeters(), 0.001);
        assertEquals(1.0, km.convertFromMeters(1000.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMillimeter() {
        new Millimeter(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCentimeter() {
        new Centimeter(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDecimeter() {
        new Decimeter(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMeter() {
        new Meter(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeKilometer() {
        new Kilometer(-1);
    }
} 