package Task_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_1 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        try {
            System.out.print("Enter first number: ");
            num1 = scn.nextInt();
            System.out.print("Enter second number: ");
            num2 = scn.nextInt();
            System.out.print("Enter third number: ");
            num3 = scn.nextInt();

            int result = Integer.parseInt("" + num1 + num2 + num3);
            System.out.println("Created number: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter an integer number");;
        } catch (NumberFormatException e) {
            System.out.println("Error: please enter a positive integer numbers only");
        } finally {
            scn.close();
        }
    }
}
