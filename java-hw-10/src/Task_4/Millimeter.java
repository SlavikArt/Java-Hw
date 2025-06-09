package Task_4;

public class Millimeter implements LengthUnit {
    private final double value;

    public Millimeter(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToMeters() {
        return value / 1000.0;
    }

    @Override
    public double convertFromMeters(double meters) {
        return meters * 1000.0;
    }
} 