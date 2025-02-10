package Task_3;

import java.util.Scanner;

public class Task_3 {
    public static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("--- Enter data for the Car ---");
            Car car = new Car();
            car.inputData(scn);
            System.out.println("\nCar Information:");
            car.printData();
            System.out.println("\nCar Information (short):");
            car.printData(true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scn.close();
        }
    }
}
