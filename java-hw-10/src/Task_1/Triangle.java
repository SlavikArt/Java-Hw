package Task_1;

public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) throws IllegalArgumentException {
        if(base <= 0 || height <= 0)
            throw new IllegalArgumentException("Base and height must be positive");
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}
