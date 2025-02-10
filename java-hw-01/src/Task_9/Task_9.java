package Task_9;

import java.util.Random;
import java.util.Scanner;

public class Task_9 {
    public static final Scanner scn = new Scanner(System.in);
    public static final Random rnd = new Random();

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            int[][] arr;
            int rows, cols;

            System.out.println("Choose the method:");
            System.out.println("1. Generate a random array");
            System.out.println("2. Enter an array");

            switch(scn.nextInt()) {
                case 1:
                    System.out.print("Enter rows count: ");
                    rows = scn.nextInt();
                    cols = rnd.nextInt(1, 51);

                    arr = new int[rows][cols];
                    for (int i = 0; i < rows; i++)
                        for(int j = 0; j < cols; j++)
                            arr[i][j] = rnd.nextInt(-100, 101);
                    break;

                case 2:
                    System.out.print("Enter rows count: ");
                    rows = scn.nextInt();
                    scn.nextLine();

                    arr = new int[rows][];
                    for (int i = 0; i < rows; i++) {
                        System.out.println("Enter numbers for row #" + (i+1) + " using ',':");
                        String[] values = scn.nextLine().split(",");

                        arr[i] = new int[values.length];
                        for(int j = 0; j < values.length; j++)
                            arr[i][j] = Integer.parseInt(values[j]);
                    }
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    return;
            }

            double[] ratios = new double[rows];

            for (int i = 0; i < rows; i++) {
                int zeroCnt = 0;
                int nonZeroCnt = 0;

                for(int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 0)
                        zeroCnt++;
                    else
                        nonZeroCnt++;
                }
                ratios[i] = (double)zeroCnt / nonZeroCnt;
            }

            System.out.println("Ratios zero to non-zero is:");
            for(int i = 0; i < rows; i++)
                System.out.printf("%.2f ", ratios[i]);

            System.out.println("\nArrays:");
            for (int i = 0; i < arr.length; i++)
                printArray(arr[i]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scn.close();
        }
    }
}
