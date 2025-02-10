package Task_2;

public class Course {
    private String name;
    private boolean isPassed;

    public Course(String name, boolean isPassed) {
        this.name = name;
        this.isPassed = isPassed;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public String getName() {
        return name;
    }
}
