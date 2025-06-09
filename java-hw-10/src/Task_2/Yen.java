package Task_2;

public class Yen implements Currency {
    private final double value;
    private static final double EXCHANGE_RATE = 0.0067; // 1 JPY = 0.0067 USD

    public Yen(double value) {
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