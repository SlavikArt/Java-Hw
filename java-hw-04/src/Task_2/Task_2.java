package Task_2;

public class Task_2 {
    public static void main(String[] args) {
        Course[] courses1 = {
                new Course("Математика", true),
                new Course("Фізика", false),
                new Course("Хімія", true)
        };
        Student student1 = new Student("Олексій", courses1);

        Course[] courses2 = {
                new Course("Математика", false),
                new Course("Фізика", false),
                new Course("Хімія", false)
        };
        Student student2 = new Student("Анна", courses2);

        Course[] courses3 = {
                new Course("Математика", true),
                new Course("Фізика", true),
                new Course("Інформатика", true)
        };
        Student student3 = new Student("Марія", courses3);

        Course[] courses4 = {
                new Course("Математика", true),
                new Course("Фізика", false),
                new Course("Історія", true)
        };
        Student student4 = new Student("Іван", courses4);

        Student[] students = {student1, student2, student3, student4};
        Group group = new Group(students);

        group.printFailedStudents();
        group.printSuccessfulStudents();
        group.printAllRatings();
    }
}
