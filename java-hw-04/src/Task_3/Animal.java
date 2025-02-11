package Task_3;

public abstract class Animal {
    private String name;
    private boolean isPredator;
    private String foodType;
    private double foodAmount;

    public Animal(String name, boolean isPredator, String foodType, double foodAmount) {
        this.name = name;
        this.isPredator = isPredator;
        this.foodType = foodType;
        this.foodAmount = foodAmount;
    }

    public abstract String makeSound();

    public boolean isPredator() {
        return isPredator;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public String getInfo() {
        return "Тварина: " + name + ", Звук: " + makeSound();
    }
}
