package Task_2;

public class Course {
    private String name;
    private int semester;
    private boolean isPassed;

    public Course(String name, int semester, boolean isPassed) {
        this.name = name;
        this.semester = semester;
        this.isPassed = isPassed;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public boolean isPassed() {
        return isPassed;
    }
}
