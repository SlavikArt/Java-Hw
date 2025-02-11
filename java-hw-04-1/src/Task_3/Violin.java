package Task_3;

public class Violin extends MusicalInstrument {
    public Violin() {
        super("Скрипка", "4-струнний смичковий інструмент");
    }

    @Override public void Sound() {
        System.out.println("Трррррррр!");
    }
    @Override public void History() {
        System.out.println("З'явилась в Італії у 16 ст.");
    }
}
