package Task_1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeAreaTest {
    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(4, 5);
        assertEquals(10.0, triangle.area(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        new Triangle(-4, 5);
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 5);
        assertEquals(20.0, rectangle.area(), 0.001);
    }

    @Test
    public void testSquareArea() {
        Square square = new Square(4);
        assertEquals(16.0, square.area(), 0.001);
    }

    @Test
    public void testRhombusArea() {
        Rhombus rhombus = new Rhombus(6, 8);
        assertEquals(24.0, rhombus.area(), 0.001);
    }
}
