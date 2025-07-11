package Task_4;

public class Centimeter implements LengthUnit {
    private final double value;

    public Centimeter(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToMeters() {
        return value / 100.0;
    }

    @Override
    public double convertFromMeters(double meters) {
        return meters * 100.0;
    }
} 