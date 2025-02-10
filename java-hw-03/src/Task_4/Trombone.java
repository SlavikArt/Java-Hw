package Task_4;

public class Trombone extends MusicalInstrument {
    public Trombone() {
        super("Тромбон", "Мідний духовий інструмент з кулісою");
    }

    @Override public void Sound() {
        System.out.println("Ду-ду-ду!");
    }
    @Override public void History() {
        System.out.println("Створений у 15 ст. у Німеччині");
    }
}
