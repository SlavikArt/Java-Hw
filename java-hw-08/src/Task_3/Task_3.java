package Task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введіть шлях до файлу:");
        String filePath = scn.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int totalSum = 0;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    System.out.println("Рядок " + lineNumber + " пустий.");
                    continue;
                }

                String[] strArray = line.split("\\s+");
                try {
                    int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
                    if (intArray.length == 0) {
                        System.out.println("Масив з рядка " + lineNumber + " пустий.");
                        continue;
                    }

                    System.out.println("Масив з рядка " + lineNumber + ": " + Arrays.toString(intArray));
                    int max = Arrays.stream(intArray).max().getAsInt();
                    int min = Arrays.stream(intArray).min().getAsInt();
                    int sum = Arrays.stream(intArray).sum();

                    System.out.println("Max: " + max);
                    System.out.println("Min: " + min);
                    System.out.println("Sum: " + sum);
                    totalSum += sum;
                    System.out.println("-------------------");
                } catch (NumberFormatException e) {
                    System.out.println("Неправильні дані у рядку " + lineNumber + ": " + line);
                }
            }

            System.out.println("Сума усіх елементів: " + totalSum);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
