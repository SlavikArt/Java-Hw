package Task_1;

import java.util.Scanner;

public class Task_1 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("--- Enter data for the Country ---");
            Country country = new Country();
            country.inputData(scn);
            System.out.println("\nCountry Information:");
            country.printData();
            System.out.println("\nCountry Information (short):");
            country.printData(true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
