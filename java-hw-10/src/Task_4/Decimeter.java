package Task_4;

public class Decimeter implements LengthUnit {
    private final double value;

    public Decimeter(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToMeters() {
        return value / 10.0;
    }

    @Override
    public double convertFromMeters(double meters) {
        return meters * 10.0;
    }
} 