package Task_6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_6 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;

        try {
            System.out.print("Enter first number: ");
            num1 = scn.nextInt();
            System.out.print("Enter second number: ");
            num2 = scn.nextInt();

            int start = Math.min(num1, num2);
            int end = Math.max(num1, num2);

            System.out.println("Normalized range: from " + start + " to " + end);

            System.out.print("Odd numbers in the range: ");
            for (int i = start; i <= end; i++)
                if (i % 2 != 0)
                    System.out.print(i + " ");
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter an integer number");
        } finally {
            scn.close();
        }
    }
}
