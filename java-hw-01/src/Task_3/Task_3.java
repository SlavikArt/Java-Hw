package Task_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_3 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Enter a six-digit number: ");
            String num = scn.next();

            if (num.length() != 6 || !num.matches("[0-9]+"))
                System.out.println("Error: please enter a six-digit number");
            else {
                char[] arr = num.toCharArray();

                char tmp = arr[0];
                arr[0] = arr[5];
                arr[5] = tmp;

                tmp = arr[1];
                arr[1] = arr[4];
                arr[4] = tmp;

                System.out.println("Your number: " + num);
                System.out.println("New number: " + new String(arr));
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter a valid six-digit number");
        } finally {
            scn.close();
        }
    }
}
