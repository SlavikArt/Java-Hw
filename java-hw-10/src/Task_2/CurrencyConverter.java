package Task_2;

public class CurrencyConverter {
    private static final double EUR_RATE = 0.9259;  // 1 EUR = 0.9259 USD
    private static final double GBP_RATE = 0.7874;  // 1 GBP = 0.7874 USD
    private static final double JPY_RATE = 0.0067;  // 1 JPY = 0.0067 USD

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Currencies cannot be null");
        }

        double amountInUSD = toUSD(amount, fromCurrency);
        return roundToTwoDecimals(fromUSD(amountInUSD, toCurrency));
    }

    private static double toUSD(double amount, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> amount;
            case "EUR" -> amount * EUR_RATE;
            case "GBP" -> amount * GBP_RATE;
            case "JPY" -> amount * JPY_RATE;
            default -> throw new IllegalArgumentException("Unsupported currency: " + currency);
        };
    }

    private static double fromUSD(double usdAmount, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> usdAmount;
            case "EUR" -> usdAmount / EUR_RATE;
            case "GBP" -> usdAmount / GBP_RATE;
            case "JPY" -> usdAmount / JPY_RATE;
            default -> throw new IllegalArgumentException("Unsupported currency: " + currency);
        };
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static double usdToEur(double usd) {
        return convert(usd, "USD", "EUR");
    }

    public static double usdToGbp(double usd) {
        return convert(usd, "USD", "GBP");
    }

    public static double usdToJpy(double usd) {
        return convert(usd, "USD", "JPY");
    }

    public static double eurToUsd(double eur) {
        return convert(eur, "EUR", "USD");
    }

    public static double eurToGbp(double eur) {
        return convert(eur, "EUR", "GBP");
    }

    public static double eurToJpy(double eur) {
        return convert(eur, "EUR", "JPY");
    }

    public static double gbpToUsd(double gbp) {
        return convert(gbp, "GBP", "USD");
    }

    public static double gbpToEur(double gbp) {
        return convert(gbp, "GBP", "EUR");
    }

    public static double gbpToJpy(double gbp) {
        return convert(gbp, "GBP", "JPY");
    }

    public static double jpyToUsd(double jpy) {
        return convert(jpy, "JPY", "USD");
    }

    public static double jpyToEur(double jpy) {
        return convert(jpy, "JPY", "EUR");
    }

    public static double jpyToGbp(double jpy) {
        return convert(jpy, "JPY", "GBP");
    }
}
