package Task_5;

import java.io.*;
import java.util.*;

public class Task_5 {
    private static String filePath = System.getProperty("user.dir") + "\\src\\test_files\\employees.csv";
    private static List<Employee> employees = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу з даними співробітників\n(або натисніть Enter для використання файлу за замовчуванням 'employees.csv'): ");
        String inputPath = scn.nextLine();
        if (!inputPath.isEmpty())
            filePath = inputPath;
        loadEmployees();

        boolean running = true;
        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Редагувати співробітника");
            System.out.println("3. Видалити співробітника");
            System.out.println("4. Пошук співробітника за прізвищем");
            System.out.println("5. Вивести всіх співробітників");
            System.out.println("6. Вивести співробітників за віком");
            System.out.println("7. Вивести співробітників за початковою буквою прізвища");
            System.out.println("8. Зберегти дані у файл");
            System.out.println("9. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(scn);
                    break;
                case 2:
                    editEmployee(scn);
                    break;
                case 3:
                    deleteEmployee(scn);
                    break;
                case 4:
                    searchBySurname(scn);
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    displayEmployeesByAge(scn);
                    break;
                case 7:
                    displayEmployeesBySurnameInitial(scn);
                    break;
                case 8:
                    saveEmployees();
                    System.out.println("Дані збережено.");
                    break;
                case 9:
                    running = false;
                    saveEmployees();
                    System.out.println("Вихід з програми. Дані збережено.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
        scn.close();
    }

    private static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee emp = Employee.fromCSV(line);
                if (emp != null) {
                    employees.add(emp);
                    if (emp.getId() >= nextId)
                        nextId = emp.getId() + 1;
                }
            }
            System.out.println("Дані співробітників завантажено.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні даних: " + e.getMessage());
        }
    }

    private static void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee emp : employees) {
                writer.write(emp.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних: " + e.getMessage());
        }
    }

    private static void addEmployee(Scanner scn) {
        System.out.print("Введіть ім'я: ");
        String firstName = scn.nextLine();
        System.out.print("Введіть прізвище: ");
        String lastName = scn.nextLine();
        System.out.print("Введіть вік: ");
        int age;
        try {
            age = scn.nextInt();
            scn.nextLine();
            if (age <= 0)
                throw new IllegalArgumentException("Вік має бути додатнім.");
        } catch (Exception e) {
            System.out.println("Некоректний вік. Співробітника не додано.");
            scn.nextLine();
            return;
        }
        int id = nextId++;
        employees.add(new Employee(id, firstName, lastName, age));
        System.out.println("Співробітника додано з ID: " + id);
    }

    private static void editEmployee(Scanner scn) {
        System.out.print("Введіть ID співробітника для редагування: ");
        int id = scn.nextInt();
        scn.nextLine();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            System.out.print("Введіть нове ім'я (або натисніть Enter, щоб залишити без змін): ");
            String newFirstName = scn.nextLine();
            if (!newFirstName.isEmpty())
                emp.setFirstName(newFirstName);

            System.out.print("Введіть нове прізвище (або натисніть Enter, щоб залишити без змін): ");
            String newLastName = scn.nextLine();
            if (!newLastName.isEmpty())
                emp.setLastName(newLastName);

            System.out.print("Введіть новий вік (або 0, щоб залишити без змін): ");
            int newAge = scn.nextInt();
            scn.nextLine();
            if (newAge > 0)
                emp.setAge(newAge);

            System.out.println("Дані співробітника оновлено.");
        } else
            System.out.println("Співробітника з ID " + id + " не знайдено.");
    }

    private static void deleteEmployee(Scanner scn) {
        System.out.print("Введіть ID співробітника для видалення: ");
        int id = scn.nextInt();
        scn.nextLine();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Співробітника видалено.");
        } else
            System.out.println("Співробітника з ID " + id + " не знайдено.");
    }

    private static void searchBySurname(Scanner scn) {
        System.out.print("Введіть прізвище для пошуку: ");
        String lastName = scn.nextLine();
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee emp : employees)
            if (emp.getLastName().equalsIgnoreCase(lastName))
                foundEmployees.add(emp);

        if (!foundEmployees.isEmpty()) {
            for (Employee emp : foundEmployees)
                System.out.println(emp);

            System.out.print("Бажаєте зберегти цю інформацію у файл? (так/ні): ");
            String response = scn.nextLine();
            if (response.equalsIgnoreCase("так"))
                saveEmployeesToFile(foundEmployees, "знайдені_співробітники.txt");
        } else
            System.out.println("Співробітників з прізвищем '" + lastName + "' не знайдено.");
    }

    // Виведення всіх співробітників
    private static void displayAllEmployees() {
        if (employees.isEmpty())
            System.out.println("Немає співробітників.");
        else
            for (Employee emp : employees)
                System.out.println(emp);
    }

    private static void displayEmployeesByAge(Scanner scn) {
        System.out.print("Введіть вік: ");
        int age = scn.nextInt();
        scn.nextLine();
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getAge() == age) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found)
            System.out.println("Співробітників з віком " + age + " не знайдено.");
    }

    private static void displayEmployeesBySurnameInitial(Scanner scn) {
        System.out.print("Введіть початкову букву прізвища: ");
        String initial = scn.nextLine().toUpperCase();
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getLastName().toUpperCase().startsWith(initial)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found)
            System.out.println("Співробітників з прізвищем, що починається на '" + initial + "', не знайдено.");
    }

    private static Employee findEmployeeById(int id) {
        for (Employee emp : employees)
            if (emp.getId() == id)
                return emp;
        return null;
    }

    private static void saveEmployeesToFile(List<Employee> empList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee emp : empList) {
                writer.write(emp.toString());
                writer.newLine();
            }
            System.out.println("Інформацію збережено у файл '" + fileName + "'.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні у файл: " + e.getMessage());
        }
    }
}
