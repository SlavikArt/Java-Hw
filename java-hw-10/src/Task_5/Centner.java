package Task_5;

public class Centner implements WeightUnit {
    private final double value;

    public Centner(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToKilograms() {
        return value * 100.0;
    }

    @Override
    public double convertFromKilograms(double kilograms) {
        return kilograms / 100.0;
    }
} 