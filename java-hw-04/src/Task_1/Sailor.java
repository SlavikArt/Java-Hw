package Task_1;

public class Sailor extends Human {
    private String shipName;

    public Sailor(String name, int children, String shipName) {
        super(name, children);
        this.shipName = shipName;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Корабель: " + shipName;
    }
}
