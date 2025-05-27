package Task_1;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Task_1 {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[25];
        CountDownLatch latch = new CountDownLatch(1);
        long[] sumResult = new long[1];
        double[] averageResult = new double[1];

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length; i++)
                array[i] = (int) (Math.random() * 100);
            latch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.out.println("Помилка в потоці 2: " + e.getMessage());
            }
            long sum = 0;
            for (int num : array)
                sum += num;
            sumResult[0] = sum;
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.out.println("Помилка в потоці 3: " + e.getMessage());
            }
            long sum = 0;
            for (int num : array)
                sum += num;
            averageResult[0] = (double) sum / array.length;
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Масив: " + Arrays.toString(array));
        System.out.println("Сума: " + sumResult[0]);
        System.out.println("Середнє арифметичне: " + averageResult[0]);
    }
}
