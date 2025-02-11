package Task_1;

import java.util.Scanner;

public class Task_1 {
    private static final UserDatabase db = new UserDatabase();
    private static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> removeUser();
                case 3 -> checkUser();
                case 4 -> changeLogin();
                case 5 -> changePassword();
                case 0 -> System.exit(0);
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Меню керування користувачами ---");
        System.out.println("1. Додати користувача");
        System.out.println("2. Видалити користувача");
        System.out.println("3. Перевірити наявність");
        System.out.println("4. Змінити логін");
        System.out.println("5. Змінити пароль");
        System.out.println("0. Вийти");
        System.out.print("Виберіть опцію: ");
    }

    private static void addUser() {
        System.out.print("Введіть логін: ");
        String login = scn.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scn.nextLine();

        try {
            db.addUser(login, password);
            System.out.println("Користувача додано!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void removeUser() {
        System.out.print("Введіть логін для видалення: ");
        String login = scn.nextLine();

        try {
            db.removeUser(login);
            System.out.println("Користувача видалено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void checkUser() {
        System.out.print("Введіть логін для перевірки: ");
        String login = scn.nextLine();
        System.out.println(db.userExists(login) ? "Користувач існує!" : "Користувача не знайдено!");
    }

    private static void changeLogin() {
        System.out.print("Введіть старий логін: ");
        String oldLogin = scn.nextLine();
        System.out.print("Введіть новий логін: ");
        String newLogin = scn.nextLine();

        try {
            db.updateLogin(oldLogin, newLogin);
            System.out.println("Логін успішно змінено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void changePassword() {
        System.out.print("Введіть логін: ");
        String login = scn.nextLine();
        System.out.print("Введіть новий пароль: ");
        String newPassword = scn.nextLine();

        try {
            db.updatePassword(login, newPassword);
            System.out.println("Пароль успішно змінено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
