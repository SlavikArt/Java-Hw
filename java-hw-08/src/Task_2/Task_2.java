package Task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введіть шлях до файлу:");
        String filePath = scn.nextLine();

        String longestLine = "";
        int maxLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int currentLength = line.length();
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    longestLine = line;
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            return;
        } finally {
            scn.close();
        }

        if (maxLength > 0) {
            System.out.println("Довжина найдовшого рядка: " + maxLength);
            System.out.println("Найдовший рядок: " + longestLine);
        } else
            System.out.println("Файл порожній або не містить рядків.");
    }
}
