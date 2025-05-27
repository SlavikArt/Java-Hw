package Task_2;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scn.nextLine();

        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger totalNumbers = new AtomicInteger(0);
        AtomicInteger primeCount = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                for (int i = 0; i < 100; i++) {
                    int num = (int) (Math.random() * 21);
                    writer.println(num);
                }
                totalNumbers.set(100);
            } catch (IOException e) {
                System.out.println("Помилка при записі у файл: " + e.getMessage());
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
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    PrintWriter primeWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir") +"\\src\\test_files\\primes.txt"))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int num = Integer.parseInt(line);
                    if (isPrime(num)) {
                        primeWriter.println(num);
                        primeCount.incrementAndGet();
                    }
                }
                primeWriter.println();
            } catch (IOException e) {
                System.out.println("Помилка при обробці файлу: " + e.getMessage());
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.out.println("Помилка в потоці 3: " + e.getMessage());
            }
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    PrintWriter factWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir") +"\\src\\test_files\\factorials.txt"))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int num = Integer.parseInt(line);
                    long factorial = calculateFactorial(num);
                    factWriter.println(num + "! = " + factorial);
                }
                factWriter.println();
            } catch (IOException e) {
                System.out.println("Помилка при обробці файлу: " + e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Загальна кількість чисел у файлі: " + totalNumbers.get());
        System.out.println("Кількість простих чисел: " + primeCount.get());
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    private static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
}
