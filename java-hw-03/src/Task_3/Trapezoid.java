package Task_3;

public class Trapezoid extends Figure {
    private double a, b, h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override public double calcArea() {
        return (a + b) / 2 * h;
    }
}
