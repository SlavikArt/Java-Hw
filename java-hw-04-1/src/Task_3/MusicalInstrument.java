package Task_3;

public abstract class MusicalInstrument implements IInfo {
    protected String name;
    protected String desc;

    public MusicalInstrument(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override public void Show() {
        System.out.println("Інструмент: " + name);
    }
    @Override public void Desc() {
        System.out.println("Опис: " + desc);
    }
}
