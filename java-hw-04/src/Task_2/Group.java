package Task_2;

public class Group {
    private Student[] students;

    public Group(Student[] students) {
        this.students = students;
    }

    public void printFailedStudents() {
        System.out.println("Неуспішні студенти:");
        for (int i = 0; i < students.length; i++)
            if (students[i].hasDebts())
                System.out.println(students[i].getName());
    }

    public void printSuccessfulStudents() {
        System.out.println("Успішні студенти:");
        for (int i = 0; i < students.length; i++)
            if (!students[i].hasDebts())
                System.out.println(students[i].getName());
    }

    public void printMostFailedCourses() {
        String[] courses = new String[100];
        int[] fails = new int[100];

        int count = 0;
        for (int s = 0; s < students.length; s++) {
            String[] failed = students[s].getFailedCourses();
            for (int f = 0; f < failed.length; f++) {
                String course = failed[f];
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (courses[i].equals(course)) {
                        fails[i]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    courses[count] = course;
                    fails[count] = 1;
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Немає незданих курсів.");
            return;
        }

        int maxFails = 0;
        for (int i = 0; i < count; i++) {
            if (fails[i] > maxFails) {
                maxFails = fails[i];
            }
        }

        System.out.println("Курси з найбільшою кількістю нездач:");
        for (int i = 0; i < count; i++)
            if (fails[i] == maxFails)
                System.out.println(courses[i] + " - " + fails[i] + " нездач");
    }

    public void printAllRatings() {
        System.out.println("Рейтинги студентів:");
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%s: %.1f\n", students[i].getName(), students[i].getRating());
        }
    }

    public void printCoursesBySemester(String studentName, int semester) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(studentName)) {
                System.out.println("Курси студента " + studentName + " у семестрі " + semester + ":");
                System.out.println(students[i].getCoursesBySemester(semester));
                return;
            }
        }
        System.out.println("Студент не знайдений");
    }
}
