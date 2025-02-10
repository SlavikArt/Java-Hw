package Task_2;

import java.util.Scanner;

public class Task_2 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("--- Enter data for the Book ---");
            Book book = new Book();
            book.inputData(scn);
            System.out.println("\nBook Information:");
            book.printData();
            System.out.println("\nBook Information (short):");
            book.printData(true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
