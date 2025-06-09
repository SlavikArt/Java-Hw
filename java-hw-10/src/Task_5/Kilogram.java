package Task_5;

public class Kilogram implements WeightUnit {
    private final double value;

    public Kilogram(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToKilograms() {
        return value;
    }

    @Override
    public double convertFromKilograms(double kilograms) {
        return kilograms;
    }
} 