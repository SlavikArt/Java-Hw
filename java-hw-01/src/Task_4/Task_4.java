package Task_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_4 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Enter a month number (1-12): ");
            int month = scn.nextInt();

            switch (month) {
                case 1:
                case 2:
                case 12:
                    System.out.println("Winter");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Spring");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("Summer");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("Autumn");
                    break;
                default:
                    System.out.println("Error: please enter a valid month number (1-12)");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter a valid month number (1-12)");
        } finally {
            scn.close();
        }
    }
}
