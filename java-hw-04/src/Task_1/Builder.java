package Task_1;

public class Builder extends Human {
    private String specialty;

    public Builder(String name, int children, String specialty) {
        super(name, children);
        this.specialty = specialty;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Спеціальність: " + specialty;
    }
}
