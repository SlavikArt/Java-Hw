package Task_7;

import java.util.Random;
import java.util.Scanner;

public class Task_7 {
    public static final Scanner scn = new Scanner(System.in);
    public static final Random rnd = new Random();

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            int size = rnd.nextInt(1, 51);
            int[] arr = new int[size];

            for (int i = 0; i < size; i++)
                arr[i] = rnd.nextInt(-100, 101);

            int negativeCnt = 0;
            int positiveCnt = 0;
            int zeroCnt = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0)
                    negativeCnt++;
                else if (arr[i] > 0)
                    positiveCnt++;
                else
                    zeroCnt++;
            }

            System.out.println("Array(" + size + "):");
            printArray(arr);
            System.out.println("Negative numbers: " + negativeCnt);
            System.out.println("Positive numbers: " + positiveCnt);
            System.out.println("Zeroes: " + zeroCnt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scn.close();
        }
    }
}