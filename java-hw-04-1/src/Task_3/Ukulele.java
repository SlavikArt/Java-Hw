package Task_3;

public class Ukulele extends MusicalInstrument {
    public Ukulele() {
        super("Укулеле", "4-струнний гавайський інструмент");
    }

    @Override public void Sound() {
        System.out.println("Плінь-плінь!");
    }
    @Override public void History() {
        System.out.println("Походить з Гаваїв 19 ст.");
    }
}
