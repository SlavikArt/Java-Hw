package Task_5;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_5 {
    public static final Scanner scn = new Scanner(System.in);

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            System.out.print("Enter the size of the array: ");
            int size = scn.nextInt();

            int[] arr = new int[size];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++)
                arr[i] = scn.nextInt();

            int[] arrCopy = Arrays.copyOf(arr, size);

            int max = arr[0];
            int min = arr[0];
            int maxIndex = 0;
            int minIndex = 0;

            for (int i = 1; i < size; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }

            int start = Math.min(minIndex, maxIndex);
            int end = Math.max(minIndex, maxIndex);

            for (int i = start + 1; i < end; i++)
                arr[i] *= 2;

            System.out.println("Your Array:");
            printArray(arrCopy);

            System.out.println("New Array:");
            printArray(arr);
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter a valid input");
        } finally {
            scn.close();
        }
    }
}
