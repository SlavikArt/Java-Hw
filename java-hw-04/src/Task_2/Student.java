package Task_2;

public class Student {
    private String name;
    private Course[] courses;

    public Student(String name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public boolean hasDebts() {
        for (int i = 0; i < courses.length; i++) {
            if (!courses[i].isPassed()) return true;
        }
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
                sum += 100; // Припускаємо, що залік дає 100 балів
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public String[] getFailedCourses() {
        String[] failedCourses = new String[courses.length];

        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (!courses[i].isPassed()) {
                failedCourses[count] = courses[i].getName();
                count++;
            }
        }

        String[] result = new String[count];
        for (int i = 0; i < count; i++)
            result[i] = failedCourses[i];
        return result;
    }


    public String getCoursesBySemester(int semester) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < courses.length; i++)
            if (courses[i].getSemester() == semester)
                result.append(courses[i].getName()).append(", ");
        return result.length() > 0 ? result.toString() : "Немає курсів у цьому семестрі";
    }
}
