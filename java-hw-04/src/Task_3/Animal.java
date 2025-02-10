package Task_3;

public abstract class Animal {
    private String name;
    private boolean isPredator;
    private double foodAmount;

    public Animal(String name, boolean isPredator, double foodAmount) {
        this.name = name;
        this.isPredator = isPredator;
        this.foodAmount = foodAmount;
    }

    public String getName() {
        return name;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public double getFoodAmount() {
        return foodAmount;
    }
}
