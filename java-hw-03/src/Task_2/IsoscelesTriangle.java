package Task_2;

public class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double side, double base) {
        super(side, side, base);
    }

    public double calcPerimeter() {
        return 2 * getA() + getC();
    }
}
