package Task_3;

import java.util.Scanner;

class Car {
    private String name;
    private String manufacturer;
    private int yearOfProduction;
    private double engineDisplacement;

    public Car() {
        this.name = "";
        this.manufacturer = "";
        this.yearOfProduction = 0;
        this.engineDisplacement = 0.0;
    }

    public Car(String name, String manufacturer,
               int yearOfProduction, double engineDisplacement) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearOfProduction = yearOfProduction;
        this.engineDisplacement = engineDisplacement;
    }

    public Car(String name, String manufacturer) {
        this();
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public void inputData(Scanner sc) {
        System.out.print("Car Name: ");
        this.name = sc.nextLine();

        System.out.print("Manufacturer: ");
        this.manufacturer = sc.nextLine();

        System.out.print("Year of Production: ");
        this.yearOfProduction = Integer.parseInt(sc.nextLine());

        System.out.print("Engine Displacement: ");
        this.engineDisplacement = Double.parseDouble(sc.nextLine());
    }

    public void printData() {
        System.out.println("Car Name: " + name);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year of Production: " + yearOfProduction);
        System.out.println("Engine Displacement: " + engineDisplacement);
    }

    public void printData(boolean shortDescription) {
        if (shortDescription)
            System.out.println("Car Name: " + name + ", Year: " + yearOfProduction);
        else
            printData();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getYearOfProduction() { return yearOfProduction; }
    public void setYearOfProduction(int yearOfProduction) { this.yearOfProduction = yearOfProduction; }

    public double getEngineDisplacement() { return engineDisplacement; }
    public void setEngineDisplacement(double engineDisplacement) { this.engineDisplacement = engineDisplacement; }
}
