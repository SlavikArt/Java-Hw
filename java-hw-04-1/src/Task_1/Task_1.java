package Task_1;

import java.util.Scanner;

public class Task_1 {
    private static final Scanner scn = new Scanner(System.in);
    private static Bank bank;

    public static void main(String[] args) {
        initializeBank();
        showMainMenu();
    }

    private static void initializeBank() {
        try {
            bank = new Bank(1);
            int[] denoms = {500, 200, 100, 50, 20, 10, 5, 2, 1};
            int[] counts = {10, 10, 10, 10, 10, 10, 10, 10, 10};
            bank.initATM(0, denoms, counts, 100, 40);
        } catch (ATMException e) {
            System.out.println("Помилка ініціалізації: " + e.getMessage());
        }
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n--- Меню банкомату ---");
            System.out.println("1. Переглянути баланс");
            System.out.println("2. Зняти гроші");
            System.out.println("3. Поповнити банкомат");
            System.out.println("4. Вийти");
            System.out.print("Виберіть опцію: ");

            try {
                int choice = Integer.parseInt(scn.nextLine());
                switch (choice) {
                    case 1 -> showBalance();
                    case 2 -> withdrawMoney();
                    case 3 -> depositMoney();
                    case 4 -> System.exit(0);
                    default -> System.out.println("Невірний вибір!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введіть число!");
            } catch (ATMException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void showBalance() throws ATMException {
        ATM atm = bank.getATM(0);
        System.out.println("\nСтан банкомату:");
        System.out.println(atm.getStatus());
        System.out.println("Загальна сума: " + atm.getTotal() + " грн");
    }

    private static void withdrawMoney() throws ATMException {
        System.out.print("\nВведіть суму для зняття: ");
        int amount = Integer.parseInt(scn.nextLine());
        ATM atm = bank.getATM(0);

        int[] result = atm.withdraw(amount);
        System.out.println("Видано:");
        int[] denoms = atm.getDenominations();
        for (int i = 0; i < denoms.length; i++)
            if (result[i] > 0)
                System.out.println(denoms[i] + " грн: " + result[i] + " шт");
    }

    private static void depositMoney() throws ATMException {
        ATM atm = bank.getATM(0);
        int[] denoms = atm.getDenominations();
        int[] counts = new int[denoms.length];

        System.out.println("\nВведіть кількість купюр для кожного номіналу:");
        for (int i = 0; i < denoms.length; i++) {
            System.out.print(denoms[i] + " грн: ");
            counts[i] = Integer.parseInt(scn.nextLine());
        }
        atm.deposit(counts);
        System.out.println("Купюри успішно додані!");
    }
}
