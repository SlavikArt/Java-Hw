package Task_1;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) throws IllegalArgumentException {
        if(width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height must be positive");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
