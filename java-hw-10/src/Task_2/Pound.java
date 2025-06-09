package Task_2;

public class Pound implements Currency {
    private final double value;
    private static final double EXCHANGE_RATE = 1.27; // 1 GBP = 1.27 USD

    public Pound(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.value = value;
    }

    @Override
    public double convertToDollars() {
        return value * EXCHANGE_RATE;
    }

    @Override
    public double convertFromDollars(double dollars) {
        return dollars / EXCHANGE_RATE;
    }
} 