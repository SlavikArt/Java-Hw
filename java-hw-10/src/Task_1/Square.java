package Task_1;

public class Square implements Shape {
    private double side;

    public Square(double side) throws IllegalArgumentException {
        if(side <= 0)
            throw new IllegalArgumentException("Side must be positive");
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
