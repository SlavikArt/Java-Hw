package Task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_2 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        double x = 0;
        double percent = 0;

        try {
            System.out.print("Enter X: ");
            x = scn.nextDouble();
            System.out.print("Enter % to be calculated from X: ");
            percent = scn.nextDouble();

            double result = (x / 100) * percent;
            System.out.println(percent + " % from " + x + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter a valid number");
        } finally {
            scn.close();
        }
    }
}
