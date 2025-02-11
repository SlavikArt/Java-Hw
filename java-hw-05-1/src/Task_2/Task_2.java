package Task_2;

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner scn = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int choice = getChoice(scn);
            running = processChoice(choice, dict, scn);
        }
    }

    private static void showMenu() {
        System.out.println("\nМеню словника:");
        System.out.println("1. Додати слово");
        System.out.println("2. Додати переклад слова");
        System.out.println("3. Відобразити слово і його переклади");
        System.out.println("4. Замінити переклад слова");
        System.out.println("5. Видалити переклад");
        System.out.println("6. Видалити слово");
        System.out.println("7. Топ-10 популярних слів");
        System.out.println("8. Топ-10 непопулярних слів");
        System.out.println("9. Вийти");
        System.out.print("Ваш вибір: ");
    }

    private static int getChoice(Scanner scn) {
        int choice = scn.nextInt();
        scn.nextLine();
        return choice;
    }

    private static boolean processChoice(int choice, Dictionary dict, Scanner scn) {
        switch (choice) {
            case 1 -> addWord(dict, scn);
            case 2 -> addTranslation(dict, scn);
            case 3 -> displayWord(dict, scn);
            case 4 -> replaceTranslation(dict, scn);
            case 5 -> removeTranslation(dict, scn);
            case 6 -> removeWord(dict, scn);
            case 7 -> dict.displayTopPopularWords();
            case 8 -> dict.displayTopUnpopularWords();
            case 9 -> { return false; }
            default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
        return true;
    }

    private static void addWord(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово: ");
        String word = scn.nextLine();
        dict.addWord(word);
    }

    private static void addTranslation(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово: ");
        String word = scn.nextLine();
        System.out.print("Введіть переклад: ");
        String translation = scn.nextLine();
        dict.addTranslation(word, translation);
    }

    private static void displayWord(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово: ");
        String word = scn.nextLine();
        dict.displayWord(word);
    }

    private static void replaceTranslation(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово: ");
        String word = scn.nextLine();
        System.out.print("Введіть старий переклад: ");
        String oldTranslation = scn.nextLine();
        System.out.print("Введіть новий переклад: ");
        String newTranslation = scn.nextLine();
        dict.replaceTranslation(word, oldTranslation, newTranslation);
    }

    private static void removeTranslation(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово: ");
        String word = scn.nextLine();
        System.out.print("Введіть переклад для видалення: ");
        String translation = scn.nextLine();
        dict.removeTranslation(word, translation);
    }

    private static void removeWord(Dictionary dict, Scanner scn) {
        System.out.print("Введіть слово для видалення: ");
        String word = scn.nextLine();
        dict.removeWord(word);
    }
}
