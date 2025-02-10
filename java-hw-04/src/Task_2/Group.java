package Task_2;

public class Group {
    private Student[] students;

    public Group(Student[] students) {
        this.students = students;
    }

    public void printFailedStudents() {
        System.out.println("Студенти з боргами:");
        for (int i = 0; i < students.length; i++) {
            if (students[i].hasDebts()) {
                System.out.println(students[i].getName());
            }
        }
    }

    public void printSuccessfulStudents() {
        System.out.println("Студенти без боргів:");
        for (int i = 0; i < students.length; i++) {
            if (!students[i].hasDebts()) {
                System.out.println(students[i].getName());
            }
        }
    }

    public void printAllRatings() {
        System.out.println("Рейтинги студентів:");
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%s: %.1f\n", students[i].getName(), students[i].getRating());
        }
    }
}
