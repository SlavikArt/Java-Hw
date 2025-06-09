package com.itstep;

import com.itstep.model.*;
import com.itstep.service.CoffeeShopService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class QueryTest {
    private static final CoffeeShopService service = new CoffeeShopService();

    public static void main(String[] args) {
        try {
            addTestData();

            // Task 1: Customer discount queries
            System.out.println("\n=== Task 1: Customer Discount Queries ===");
            System.out.println("Min discount: " + service.getMinCustomerDiscount());
            System.out.println("Max discount: " + service.getMaxCustomerDiscount());
            System.out.println("Average discount: " + service.getAverageCustomerDiscount());
            
            System.out.println("\nCustomers with min discount:");
            service.getCustomersWithMinDiscount().forEach(c -> 
                System.out.println(c.getFullName() + " - " + c.getDiscountPercent() + "%"));
            
            System.out.println("\nCustomers with max discount:");
            service.getCustomersWithMaxDiscount().forEach(c -> 
                System.out.println(c.getFullName() + " - " + c.getDiscountPercent() + "%"));

            // Task 2: Customer age and birthday queries
            System.out.println("\n=== Task 2: Customer Age and Birthday Queries ===");
            Customer youngest = service.getYoungestCustomer();
            Customer oldest = service.getOldestCustomer();
            System.out.println("Youngest customer: " + youngest.getFullName() + 
                             " (born " + youngest.getBirthDate() + ")");
            System.out.println("Oldest customer: " + oldest.getFullName() + 
                             " (born " + oldest.getBirthDate() + ")");
            
            System.out.println("\nCustomers with birthday today:");
            service.getCustomersWithBirthdayToday().forEach(c -> 
                System.out.println(c.getFullName() + " - " + c.getBirthDate()));
            
            System.out.println("\nCustomers without address:");
            service.getCustomersWithoutAddress().forEach(c -> 
                System.out.println(c.getFullName()));

            // Task 3: Order queries
            System.out.println("\n=== Task 3: Order Queries ===");
            LocalDate today = LocalDate.now();
            System.out.println("\nOrders for today:");
            service.getOrdersByDate(today).forEach(o -> 
                System.out.println("Order #" + o.getId() + " - " + o.getTotalAmount()));
            
            System.out.println("\nOrders for this week:");
            service.getOrdersByDateRange(today.minusDays(7), today).forEach(o -> 
                System.out.println("Order #" + o.getId() + " - " + o.getTotalAmount()));
            
            System.out.println("\nDessert orders today: " + service.getDessertOrdersCountByDate(today));
            System.out.println("Drink orders today: " + service.getDrinkOrdersCountByDate(today));

            // Task 4: Customer and order statistics
            System.out.println("\n=== Task 4: Customer and Order Statistics ===");
            System.out.println("\nCustomers who ordered drinks today:");
            service.getCustomersWithDrinksToday().forEach(info -> 
                System.out.println("Customer: " + info.getCustomer().getFullName() + 
                                 ", Barista: " + info.getStaff().getFullName() + 
                                 ", Amount: " + info.getTotalAmount()));
            
            System.out.println("\nOrder statistics for today:");
            System.out.println("Average order amount: " + service.getAverageOrderAmountByDate(today));
            System.out.println("Max order amount: " + service.getMaxOrderAmountByDate(today));
            Customer maxOrderCustomer = service.getCustomerWithMaxOrderAmountByDate(today);
            if (maxOrderCustomer != null) {
                System.out.println("Customer with max order: " + maxOrderCustomer.getFullName());
            }

            // Task 5: Work schedule queries
            System.out.println("\n=== Task 5: Work Schedule Queries ===");
            LocalDate weekStart = today.minusDays(today.getDayOfWeek().getValue() - 1);
            
            System.out.println("\nSchedule for barista #1 this week:");
            service.getBaristaScheduleForWeek(1L, weekStart).forEach(schedule -> 
                System.out.println(schedule.getWorkDate() + ": " + 
                                 schedule.getStartTime() + " - " + schedule.getEndTime()));
            
            System.out.println("\nSchedule for all baristas this week:");
            service.getAllBaristasScheduleForWeek(weekStart).forEach(schedule -> 
                System.out.println(schedule.getWorkDate() + ": " + 
                                 schedule.getStartTime() + " - " + schedule.getEndTime()));
            
            System.out.println("\nSchedule for all staff this week:");
            service.getAllStaffScheduleForWeek(weekStart).forEach(schedule -> 
                System.out.println(schedule.getWorkDate() + ": " + 
                                 schedule.getStartTime() + " - " + schedule.getEndTime()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addTestData() throws SQLException {
        // Add customers with different discounts
        service.addCustomer("John Doe", LocalDate.of(1990, 5, 15), "+1234567890", "123 Main St", new BigDecimal("5.0"));
        service.addCustomer("Jane Smith", LocalDate.of(1985, 8, 20), "+0987654321", "456 Oak St", new BigDecimal("10.0"));
        service.addCustomer("Bob Johnson", LocalDate.of(1995, 3, 10), "+1122334455", "456 Oak St", new BigDecimal("15.0"));
        service.addCustomer("Alice Brown", LocalDate.of(1980, 12, 25), "+5544332211", "789 Pine St", new BigDecimal("20.0"));

        // Add staff
        service.addStaff("Mike Wilson", "BARISTA", "+1112223333", "123 Main St", LocalDate.of(2020, 1, 1));
        service.addStaff("Sarah Davis", "BARISTA", "+4445556666", "123 Main St", LocalDate.of(2021, 3, 15));
        service.addStaff("Tom Anderson", "CONFECTIONER", "+7778889999", "123 Main St", LocalDate.of(2019, 6, 1));

        // Add work schedules
        LocalDate today = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        for (int i = 0; i < 7; i++) {
            LocalDate workDate = today.plusDays(i);
            service.addWorkSchedule(1L, workDate, startTime, endTime);
            service.addWorkSchedule(2L, workDate, startTime, endTime);
            service.addWorkSchedule(3L, workDate, startTime, endTime);
        }

        // Add menu items
        service.addMenuItem("Coffee", "Кава", "DRINK", new BigDecimal("2.50"));
        service.addMenuItem("Tea", "Чай", "DRINK", new BigDecimal("2.00"));
        service.addMenuItem("Cake", "Торт", "DESSERT", new BigDecimal("4.50"));
        service.addMenuItem("Cookie", "Печиво", "DESSERT", new BigDecimal("1.50"));



        // Add orders
        service.addOrder(1L, 1L, LocalDateTime.now(), new BigDecimal("10.00"));
        service.addOrder(2L, 2L, LocalDateTime.now(), new BigDecimal("15.00"));
        service.addOrder(4L, 1L, LocalDateTime.now(), new BigDecimal("20.00"));
    }
} 