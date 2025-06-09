package Task_5;

public class Milligram implements WeightUnit {
    private final double value;

    public Milligram(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToKilograms() {
        return value / 1000000.0;
    }

    @Override
    public double convertFromKilograms(double kilograms) {
        return kilograms * 1000000.0;
    }
} 