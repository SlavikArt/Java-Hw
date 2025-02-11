package Task_1;

public class Pilot extends Human {
    private String aircraftType;

    public Pilot(String name, int children, String aircraftType) {
        super(name, children);
        this.aircraftType = aircraftType;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Літак: " + aircraftType;
    }
}
