package Task_3;

public class Tiger extends Animal {
    public Tiger() {
        super("Тигр", true, "М'ясо", 15.5);
    }

    @Override
    public String makeSound() {
        return "Рррр!";
    }
}
