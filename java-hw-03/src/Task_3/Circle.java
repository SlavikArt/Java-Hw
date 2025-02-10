package Task_3;

public class Circle extends Figure {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override public double calcArea() {
        return Math.PI * r * r;
    }
}
