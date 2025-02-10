package Task_12;

import java.util.Random;
import java.util.Scanner;

public class Task_12 {
    public static final Scanner scn = new Scanner(System.in);
    public static final Random rnd = new Random();

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = scn.nextInt();

        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = rnd.nextDouble() * 20 - 10;

        System.out.println("Original array:");
        printArray(arr);

        double[] sortedArr = sortAroundMax(arr);

        System.out.println("Sorted array:");
        printArray(sortedArr);

        scn.close();
    }

    public static double[] sortAroundMax(double[] arr) {
        if (arr.length == 0) return new double[0];

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[maxIndex])
                maxIndex = i;

        double[] leftPart = new double[maxIndex + 1];
        double[] rightPart = new double[arr.length - maxIndex - 1];

        for (int i = 0; i <= maxIndex; i++)
            leftPart[i] = arr[i];
        for (int i = 0; i < rightPart.length; i++)
            rightPart[i] = arr[maxIndex + 1 + i];

        for (int i = 0; i < leftPart.length; i++)
            for (int j = 0; j < leftPart.length - i - 1; j++)
                if (leftPart[j] > leftPart[j + 1])
                    swap(leftPart, j, j + 1);

        for (int i = 0; i < rightPart.length; i++)
            for (int j = 0; j < rightPart.length - i - 1; j++)
                if (rightPart[j] < rightPart[j + 1])
                    swap(rightPart, j, j + 1);

        double[] res = new double[arr.length];

        int i = 0;
        for (double num : leftPart)
            res[i++] = num;
        for (double num : rightPart)
            res[i++] = num;

        return res;
    }

    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(double[] arr) {
        for (double num : arr)
            System.out.printf("%.2f; ", num);
        System.out.println();
    }
}
