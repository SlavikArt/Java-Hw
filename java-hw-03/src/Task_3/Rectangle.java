package Task_3;

public class Rectangle extends Figure {
    private double w, h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override public double calcArea() {
        return w * h;
    }
}
