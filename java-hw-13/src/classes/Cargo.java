package classes;

public class Cargo {
    private String type;
    private double w;
    private int exp;

    public Cargo(String type, double w, int exp) {
        this.type = type;
        this.w = w;
        this.exp = exp;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return w;
    }

    public int getRequiredExperience() {
        return exp;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "type='" + type + '\'' +
                ", w=" + w +
                ", exp=" + exp +
                '}';
    }
} 