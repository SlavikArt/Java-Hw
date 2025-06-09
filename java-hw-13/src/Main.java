import classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dispatcher d = new Dispatcher();

        d.addDriver(new Driver("D1", "John Smith", 5));
        d.addDriver(new Driver("D2", "Mary Johnson", 3));
        d.addDriver(new Driver("D3", "Peter Brown", 2));

        d.addVehicle(new Vehicle("V1", "Truck A", 5000));
        d.addVehicle(new Vehicle("V2", "Truck B", 8000));
        d.addVehicle(new Vehicle("V3", "Truck C", 12000));
        
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        
        while (run) {
            System.out.println("\n=== Autobase Management System ===");
            System.out.println("1. Generate new request");
            System.out.println("2. Process current requests");
            System.out.println("3. Process active trips");
            System.out.println("4. Show system status");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int ch = sc.nextInt();
            
            switch (ch) {
                case 1:
                    d.generateRandomRequest();
                    break;
                case 2:
                    d.assignRequests();
                    break;
                case 3:
                    d.processTrips();
                    break;
                case 4:
                    d.printStatus();
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        sc.close();
    }
} 