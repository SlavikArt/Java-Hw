package Task_3;

import java.util.Objects;

public class Fine {
    private final String type;
    private final String city;
    private final double amount;

    public Fine(String type, String city, double amount) {
        this.type = type;
        this.city = city;
        this.amount = amount;
    }

    public String getType() { return type; }
    public String getCity() { return city; }
    public double getAmount() { return amount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fine fine = (Fine) o;
        return Double.compare(fine.amount, amount) == 0 &&
                Objects.equals(type, fine.type) &&
                Objects.equals(city, fine.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, city, amount);
    }

    @Override
    public String toString() {
        return "Тип: " + type + ", Місто: " + city + ", Сума: " + amount;
    }
}