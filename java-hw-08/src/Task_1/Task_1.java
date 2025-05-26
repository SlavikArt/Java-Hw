package Task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введіть шлях до першого файлу:");
        String filePath1 = scn.nextLine();
        System.out.println("Введіть шлях до другого файлу:");
        String filePath2 = scn.nextLine();

        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
                BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))
        ) {
            String line1, line2;
            int lineNumber = 1;
            boolean hasDifferences = false;

            while ((line1 = reader1.readLine()) != null | (line2 = reader2.readLine()) != null) {
                if (line1 == null) {
                    System.out.println("Рядок " + lineNumber + " у файлі 2: " + line2);
                    hasDifferences = true;
                    lineNumber++;
                    continue;
                }
                if (line2 == null) {
                    System.out.println("Рядок " + lineNumber + " у файлі 1: " + line1);
                    hasDifferences = true;
                    lineNumber++;
                    continue;
                }

                if (!line1.equals(line2)) {
                    System.out.println("Рядок " + lineNumber + " у файлі 1: " + line1);
                    System.out.println("Рядок " + lineNumber + " у файлі 2: " + line2);
                    hasDifferences = true;
                }
                lineNumber++;
            }

            if (!hasDifferences)
                System.out.println("Файли ідентичні.");

        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлами: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
