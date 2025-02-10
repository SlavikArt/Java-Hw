package Task_11;

import java.util.Scanner;

public class Task_11 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter lower bound: ");
        int lower = scn.nextInt();
        System.out.print("Enter upper bound: ");
        int upper = scn.nextInt();

        int sum = calculateRangeSum(lower, upper);
        System.out.println("Sum of numbers in range: " + sum);

        scn.close();
    }

    public static int calculateRangeSum(int a, int b) {
        int min, max;

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        int sum = 0;
        for (int i = min; i <= max; i++)
            sum += i;

        return sum;
    }
}
