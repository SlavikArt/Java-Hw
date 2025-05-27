package Task_4;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_4 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введіть шлях до директорії: ");
        String dirPath = scn.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String word = scn.nextLine();

        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger mergedFileCount = new AtomicInteger(0);
        AtomicInteger removedCount = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            try (PrintWriter mergedWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\test_files\\merged.txt"))) {
                Files.walkFileTree(Paths.get(dirPath), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        String content = Files.readString(file);
                        if (content.contains(word)) {
                            mergedWriter.println(content);
                            mergedFileCount.incrementAndGet();
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
                mergedWriter.println();
            } catch (IOException e) {
                System.out.println("Помилка при з’єднанні файлів: " + e.getMessage());
            } finally {
                latch.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.out.println("Помилка в потоці 2: " + e.getMessage());
            }
            List<String> forbiddenWords = new ArrayList<>();
            try (BufferedReader forbiddenReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\test_files\\forbidden.txt"))) {
                String line;
                while ((line = forbiddenReader.readLine()) != null)
                    forbiddenWords.add(line.trim());
            } catch (IOException e) {
                System.out.println("Помилка при читанні заборонених слів: " + e.getMessage());
            }
            try (BufferedReader mergedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\test_files\\merged.txt"));
                 PrintWriter cleanedWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\test_files\\cleaned.txt"))) {
                String line;
                while ((line = mergedReader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String w : words) {
                        if (!forbiddenWords.contains(w))
                            cleanedWriter.print(w + " ");
                        else
                            removedCount.incrementAndGet();
                    }
                    cleanedWriter.println();
                }
                cleanedWriter.println();
            } catch (IOException e) {
                System.out.println("Помилка при обробці файлу: " + e.getMessage());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Кількість з’єднаних файлів: " + mergedFileCount.get());
        System.out.println("Кількість видалених заборонених слів: " + removedCount.get());
    }
}
