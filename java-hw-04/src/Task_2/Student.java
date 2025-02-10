package Task_2;

public class Student {
    private String name;
    private Course[] courses;

    public Student(String name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public boolean hasDebts() {
        for (int i = 0; i < courses.length; i++)
            if (!courses[i].isPassed())
                return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].isPassed()) {
                sum += 100;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }
}
