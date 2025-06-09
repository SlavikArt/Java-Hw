package com.itstep;

import com.itstep.model.*;
import com.itstep.service.CoffeeShopService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static final CoffeeShopService service = new CoffeeShopService();

    public static void main(String[] args) {
        try {
            // Add test data
            addTestData();

            // Task 1: Menu items with names in different languages
            System.out.println("\n=== Task 1: Menu Items with Names in Different Languages ===");
            
            System.out.println("\nItems with names in both languages:");
            service.getItemsWithBothLanguages().forEach(item -> 
                System.out.println(item.getNameEn() + " / " + item.getNameUa() + " - " + item.getPrice()));
            
            System.out.println("\nItems with names in single language:");
            service.getItemsWithSingleLanguage().forEach(item -> 
                System.out.println(item.getNameEn() + " / " + item.getNameUa() + " - " + item.getPrice()));

            // Task 2 & 3: Price statistics
            System.out.println("\n=== Task 2 & 3: Price Statistics ===");
            
            System.out.println("\nDrinks:");
            System.out.println("Min price: " + service.getMinDrinkPrice());
            System.out.println("Max price: " + service.getMaxDrinkPrice());
            System.out.println("Average price: " + service.getAverageDrinkPrice());
            
            System.out.println("\nDesserts:");
            System.out.println("Min price: " + service.getMinDessertPrice());
            System.out.println("Max price: " + service.getMaxDessertPrice());
            System.out.println("Average price: " + service.getAverageDessertPrice());

            // Task 4: Staff statistics
            System.out.println("\n=== Task 4: Staff Statistics ===");
            
            System.out.println("\nStaff counts by position:");
            System.out.println("Baristas: " + service.getBaristaCount());
            System.out.println("Waiters: " + service.getWaiterCount());
            System.out.println("Confectioners: " + service.getConfectionerCount());
            
            System.out.println("\nLast hired staff:");
            Staff lastHired = service.getLastHiredStaff();
            System.out.println(lastHired.getFullName() + " - " + lastHired.getPosition() + " (hired " + lastHired.getHireDate() + ")");
            
            System.out.println("\nLongest working staff:");
            Staff longestWorking = service.getLongestWorkingStaff();
            System.out.println(longestWorking.getFullName() + " - " + longestWorking.getPosition() + " (hired " + longestWorking.getHireDate() + ")");

            // Task 5: Staff information
            System.out.println("\n=== Task 5: Staff Information ===");
            
            System.out.println("\nStaff without phone information:");
            List<Staff> staffWithoutPhone = service.getStaffWithoutPhone();
            for (Staff staff : staffWithoutPhone) {
                System.out.println(staff.getFullName() + " - " + staff.getPosition());
            }
            
            System.out.println("\nUnique first names:");
            List<String> firstNames = service.getUniqueStaffFirstNames();
            for (String name : firstNames) {
                System.out.println(name);
            }
            
            System.out.println("\nUnique last names:");
            List<String> lastNames = service.getUniqueStaffLastNames();
            for (String name : lastNames) {
                System.out.println(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addTestData() throws SQLException {
        // Add menu items (drinks and desserts)
        service.addMenuItem("Coffee", "Кава", "DRINK", new BigDecimal("2.50"));
        service.addMenuItem("Tea", "Чай", "DRINK", new BigDecimal("2.00"));
        service.addMenuItem("Cake", "Торт", "DESSERT", new BigDecimal("4.50"));
        service.addMenuItem("Cookie", "Печиво", "DESSERT", new BigDecimal("1.50"));

        // Add staff (baristas and confectioner)
        service.addStaff("Mike Wilson", "BARISTA", "+1112223333", "789 Pine St", LocalDate.of(2020, 1, 1));
        service.addStaff("Sarah Davis", "BARISTA", "+4445556666", "789 Pine St", LocalDate.of(2021, 3, 15));
        service.addStaff("Tom Anderson", "CONFECTIONER", "+7778889999", "789 Pine St", LocalDate.of(2019, 6, 1));
    }
} 