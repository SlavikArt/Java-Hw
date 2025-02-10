package Task_3;

public class RightTriangle extends Figure {
    private double a, b;

    public RightTriangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override public double calcArea() {
        return (a * b) / 2;
    }
}
