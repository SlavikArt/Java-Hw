package Task_3;

public class Wolf extends Animal {
    public Wolf() {
        super("Вовк", true, "М'ясо", 10.0);
    }

    @Override
    public String makeSound() {
        return "Аууу!";
    }
}
