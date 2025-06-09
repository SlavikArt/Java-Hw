package Task_1;

public class Rhombus implements Shape {
    private double diagonal1;
    private double diagonal2;

    public Rhombus(double diagonal1, double diagonal2) throws IllegalArgumentException {
        if(diagonal1 <= 0 || diagonal2 <= 0)
            throw new IllegalArgumentException("Diagonals must be positive");
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double area() {
        return 0.5 * diagonal1 * diagonal2;
    }
}
