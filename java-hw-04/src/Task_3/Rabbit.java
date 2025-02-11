package Task_3;

public class Rabbit extends Animal {
    public Rabbit() {
        super("Кролик", false, "Овочі", 2.0);
    }

    @Override
    public String makeSound() {
        return "Піп-піп!";
    }
}
