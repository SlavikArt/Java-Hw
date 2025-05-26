package Task_5;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Employee(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() { return "ID: " + id + ", Ім'я: " + firstName + ", Прізвище: " + lastName + ", Вік: " + age; }

    public String toCSV() { return id + "," + firstName + "," + lastName + "," + age; }

    public static Employee fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 4)
            return null;

        int id = Integer.parseInt(parts[0]);
        String firstName = parts[1];
        String lastName = parts[2];
        int age = Integer.parseInt(parts[3]);

        return new Employee(id, firstName, lastName, age);
    }
}
