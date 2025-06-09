package Task_4;

public class Meter implements LengthUnit {
    private final double value;

    public Meter(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToMeters() {
        return value;
    }

    @Override
    public double convertFromMeters(double meters) {
        return meters;
    }
} 