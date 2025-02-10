package Task_1;

import java.util.Scanner;

class Country {
    private String name;
    private String continent;
    private long population;
    private String telephoneCode;
    private String capital;
    private String[] cities;

    public Country() {
        this.name = "";
        this.continent = "";
        this.population = 0;
        this.telephoneCode = "";
        this.capital = "";
        this.cities = new String[0];
    }

    public Country(String name, String continent, long population,
                   String telephoneCode, String capital, String[] cities) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.telephoneCode = telephoneCode;
        this.capital = capital;
        this.cities = cities;
    }

    public Country(String name, String continent) {
        this();
        this.name = name;
        this.continent = continent;
    }

    public void inputData(Scanner scn) {
        System.out.print("Country Name: ");
        this.name = scn.nextLine();

        System.out.print("Continent: ");
        this.continent = scn.nextLine();

        System.out.print("Population: ");
        this.population = Long.parseLong(scn.nextLine());

        System.out.print("Telephone Code: ");
        this.telephoneCode = scn.nextLine();

        System.out.print("Capital: ");
        this.capital = scn.nextLine();

        System.out.print("Number of Cities: ");
        int numCities = Integer.parseInt(scn.nextLine());

        this.cities = new String[numCities];
        for (int i = 0; i < numCities; i++) {
            System.out.print("City " + (i + 1) + ": ");
            this.cities[i] = scn.nextLine();
        }
    }

    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("Continent: " + continent);
        System.out.println("Population: " + population);
        System.out.println("Telephone Code: " + telephoneCode);
        System.out.println("Capital: " + capital);
        System.out.print("Cities: ");
        for (int i = 0; i < cities.length; i++)
            System.out.print(cities[i] + " ");
        System.out.println();
    }

    public void printData(boolean shortDescription) {
        if (shortDescription)
            System.out.println("Country: " + name + ", Continent: " + continent);
        else
            printData();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public long getPopulation() { return population; }
    public void setPopulation(long population) { this.population = population; }

    public String getTelephoneCode() { return telephoneCode; }
    public void setTelephoneCode(String telephoneCode) { this.telephoneCode = telephoneCode; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String[] getCities() { return cities; }
    public void setCities(String[] cities) { this.cities = cities; }
}
