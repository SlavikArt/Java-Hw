package Task_3;

public class Kangaroo extends Animal {
    public Kangaroo() {
        super("Кенгуру", false, "Трава", 5.5);
    }

    @Override
    public String makeSound() {
        return "Хррр!";
    }
}
