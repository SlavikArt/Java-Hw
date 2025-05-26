package Task_4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введіть шлях до файлу:");
        String filePath = scn.nextLine();

        System.out.println("Введіть масив цілих чисел, розділених пробілами:");
        String input = scn.nextLine();

        String[] strArray = input.split("\\s+");
        int[] numbers = new int[strArray.length];
        try {
            for (int i = 0; i < strArray.length; i++)
                numbers[i] = Integer.parseInt(strArray[i]);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено некоректні дані для масиву.");
            scn.close();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            StringBuilder sbOriginal = new StringBuilder();
            for (int num : numbers) {
                sbOriginal.append(num).append(" ");
            }
            writer.write(sbOriginal.toString().trim());
            writer.newLine();

            StringBuilder sbEven = new StringBuilder();
            for (int num : numbers)
                if (num % 2 == 0)
                    sbEven.append(num).append(" ");

            writer.write(sbEven.toString().trim());
            writer.newLine();

            StringBuilder sbOdd = new StringBuilder();
            for (int num : numbers)
                if (num % 2 != 0)
                    sbOdd.append(num).append(" ");

            writer.write(sbOdd.toString().trim());
            writer.newLine();

            StringBuilder sbReversed = new StringBuilder();
            for (int i = numbers.length - 1; i >= 0; i--)
                sbReversed.append(numbers[i]).append(" ");

            writer.write(sbReversed.toString().trim());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
