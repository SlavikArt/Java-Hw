package Task_2;

public class Dollar implements Currency {
    private final double value;

    public Dollar(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToDollars() {
        return value;
    }

    @Override
    public double convertFromDollars(double dollars) {
        return dollars;
    }
} 