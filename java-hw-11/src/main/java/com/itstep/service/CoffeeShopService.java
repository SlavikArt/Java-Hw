package com.itstep.service;

import com.itstep.model.*;
import com.itstep.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class CoffeeShopService {

    public void addMenuItem(String nameEn, String nameUa, String itemType, BigDecimal price) throws SQLException {
        String sql = "INSERT INTO menu_items (name_en, name_ua, item_type, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nameEn);
            pstmt.setString(2, nameUa);
            pstmt.setString(3, itemType);
            pstmt.setBigDecimal(4, price);
            pstmt.executeUpdate();
        }
    }

    public void addBarista(String fullName, String phone, String address) throws SQLException {
        addStaff(fullName, "BARISTA", phone, address, LocalDate.now());
    }

    public void addConfectioner(String fullName, String phone, String address) throws SQLException {
        addStaff(fullName, "CONFECTIONER", phone, address, LocalDate.now());
    }

    public void addStaff(String fullName, String position, String phone, String address, LocalDate hireDate) throws SQLException {
        String sql = "INSERT INTO staff (full_name, position, phone, address, hire_date) VALUES (?, ?::position_type, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullName);
            pstmt.setString(2, position);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setDate(5, Date.valueOf(hireDate));
            pstmt.executeUpdate();
        }
    }

    public void addCustomer(String fullName, LocalDate birthDate, String phone, String address, BigDecimal discountPercent) throws SQLException {
        String sql = "INSERT INTO customers (full_name, birth_date, phone, address, discount_percent) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullName);
            pstmt.setDate(2, Date.valueOf(birthDate));
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setBigDecimal(5, discountPercent);
            pstmt.executeUpdate();
        }
    }

    public void addWorkSchedule(Long staffId, LocalDate workDate, LocalTime startTime, LocalTime endTime) throws SQLException {
        String sql = "INSERT INTO work_schedule (staff_id, work_date, start_time, end_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, staffId);
            pstmt.setDate(2, Date.valueOf(workDate));
            pstmt.setTime(3, Time.valueOf(startTime));
            pstmt.setTime(4, Time.valueOf(endTime));
            pstmt.executeUpdate();
        }
    }

    public void updateMenuItemPrice(Long itemId, double newPrice) throws SQLException {
        String sql = "UPDATE menu_items SET price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setLong(2, itemId);
            pstmt.executeUpdate();
        }
    }

    public void updateStaffAddress(Long staffId, String newAddress) throws SQLException {
        String sql = "UPDATE staff SET address = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newAddress);
            pstmt.setLong(2, staffId);
            pstmt.executeUpdate();
        }
    }

    public void updateStaffPhone(Long staffId, String newPhone) throws SQLException {
        String sql = "UPDATE staff SET phone = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPhone);
            pstmt.setLong(2, staffId);
            pstmt.executeUpdate();
        }
    }

    public void updateCustomerDiscount(Long customerId, double discountPercent) throws SQLException {
        String sql = "UPDATE customers SET discount_percent = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, discountPercent);
            pstmt.setLong(2, customerId);
            pstmt.executeUpdate();
        }
    }

    public void updateMenuItemName(Long itemId, String newNameEn, String newNameUa) throws SQLException {
        String sql = "UPDATE menu_items SET name_en = ?, name_ua = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newNameEn);
            pstmt.setString(2, newNameUa);
            pstmt.setLong(3, itemId);
            pstmt.executeUpdate();
        }
    }

    public void deleteMenuItem(Long itemId) throws SQLException {
        String sql = "DELETE FROM menu_items WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, itemId);
            pstmt.executeUpdate();
        }
    }

    public void deleteStaff(Long staffId) throws SQLException {
        String sql = "DELETE FROM staff WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, staffId);
            pstmt.executeUpdate();
        }
    }

    public void deleteCustomer(Long customerId) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, customerId);
            pstmt.executeUpdate();
        }
    }

    public void deleteOrder(Long orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, orderId);
            pstmt.executeUpdate();
        }
    }

    public List<MenuItem> getAllDrinks() throws SQLException {
        return getMenuItemsByType("DRINK");
    }

    public List<MenuItem> getAllDesserts() throws SQLException {
        return getMenuItemsByType("DESSERT");
    }

    private List<MenuItem> getMenuItemsByType(String type) throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE item_type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuItem item = new MenuItem();
                item.setId(rs.getLong("id"));
                item.setNameEn(rs.getString("name_en"));
                item.setNameUa(rs.getString("name_ua"));
                item.setPrice(rs.getBigDecimal("price"));
                item.setItemType(rs.getString("item_type"));
                item.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                items.add(item);
            }
        }
        return items;
    }

    public List<Staff> getAllBaristas() throws SQLException {
        return getStaffByPosition("BARISTA");
    }

    public List<Staff> getAllWaiters() throws SQLException {
        return getStaffByPosition("WAITER");
    }

    private List<Staff> getStaffByPosition(String position) throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE position = ?::position_type";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, position);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getLong("id"));
                staff.setFullName(rs.getString("full_name"));
                staff.setPhone(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setPosition(rs.getString("position"));
                staff.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                staffList.add(staff);
            }
        }
        return staffList;
    }

    public List<Order> getOrdersByDessert(Long dessertId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT DISTINCT o.* FROM orders o " +
                    "JOIN order_items oi ON o.id = oi.order_id " +
                    "WHERE oi.menu_item_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, dessertId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setCustomerId(rs.getLong("customer_id"));
                order.setStaffId(rs.getLong("staff_id"));
                order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> getOrdersByStaff(Long staffId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE staff_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, staffId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setCustomerId(rs.getLong("customer_id"));
                order.setStaffId(rs.getLong("staff_id"));
                order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> getOrdersByCustomer(Long customerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setCustomerId(rs.getLong("customer_id"));
                order.setStaffId(rs.getLong("staff_id"));
                order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                orders.add(order);
            }
        }
        return orders;
    }

    // Task 1: Menu items with names in different languages
    public List<MenuItem> getItemsWithBothLanguages() throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE name_en IS NOT NULL AND name_ua IS NOT NULL";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                items.add(mapMenuItem(rs));
            }
        }
        return items;
    }

    public List<MenuItem> getItemsWithSingleLanguage() throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE name_en IS NULL OR name_ua IS NULL";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                items.add(mapMenuItem(rs));
            }
        }
        return items;
    }

    public List<MenuItem> getDrinksWithBothLanguages() throws SQLException {
        return getItemsWithBothLanguagesByType("DRINK");
    }

    public List<MenuItem> getDrinksWithSingleLanguage() throws SQLException {
        return getItemsWithSingleLanguageByType("DRINK");
    }

    public List<MenuItem> getDessertsWithBothLanguages() throws SQLException {
        return getItemsWithBothLanguagesByType("DESSERT");
    }

    public List<MenuItem> getDessertsWithSingleLanguage() throws SQLException {
        return getItemsWithSingleLanguageByType("DESSERT");
    }

    public List<MenuItem> getItemsWithSameName() throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE name_en = name_ua";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                items.add(mapMenuItem(rs));
            }
        }
        return items;
    }

    private List<MenuItem> getItemsWithBothLanguagesByType(String type) throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE item_type = ? AND name_en IS NOT NULL AND name_ua IS NOT NULL";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                items.add(mapMenuItem(rs));
            }
        }
        return items;
    }

    private List<MenuItem> getItemsWithSingleLanguageByType(String type) throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE item_type = ? AND (name_en IS NULL OR name_ua IS NULL)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                items.add(mapMenuItem(rs));
            }
        }
        return items;
    }

    // Task 2 & 3: Price statistics
    public double getMinDrinkPrice() throws SQLException {
        return getMinPriceByType("DRINK");
    }

    public double getMinDessertPrice() throws SQLException {
        return getMinPriceByType("DESSERT");
    }

    public MenuItem getDrinkWithMinPrice() throws SQLException {
        return getItemWithMinPriceByType("DRINK");
    }

    public MenuItem getDessertWithMinPrice() throws SQLException {
        return getItemWithMinPriceByType("DESSERT");
    }

    public double getMaxDrinkPrice() throws SQLException {
        return getMaxPriceByType("DRINK");
    }

    public double getMaxDessertPrice() throws SQLException {
        return getMaxPriceByType("DESSERT");
    }

    public MenuItem getDrinkWithMaxPrice() throws SQLException {
        return getItemWithMaxPriceByType("DRINK");
    }

    public MenuItem getDessertWithMaxPrice() throws SQLException {
        return getItemWithMaxPriceByType("DESSERT");
    }

    public double getAverageDrinkPrice() throws SQLException {
        return getAveragePriceByType("DRINK");
    }

    public double getAverageDessertPrice() throws SQLException {
        return getAveragePriceByType("DESSERT");
    }

    public double getAverageMenuPrice() throws SQLException {
        String sql = "SELECT AVG(price) FROM menu_items";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    private double getMinPriceByType(String type) throws SQLException {
        String sql = "SELECT MIN(price) FROM menu_items WHERE item_type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    private double getMaxPriceByType(String type) throws SQLException {
        String sql = "SELECT MAX(price) FROM menu_items WHERE item_type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    private double getAveragePriceByType(String type) throws SQLException {
        String sql = "SELECT AVG(price) FROM menu_items WHERE item_type = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    private MenuItem getItemWithMinPriceByType(String type) throws SQLException {
        String sql = "SELECT * FROM menu_items WHERE item_type = ? AND price = (SELECT MIN(price) FROM menu_items WHERE item_type = ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.setString(2, type);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapMenuItem(rs);
            }
        }
        return null;
    }

    private MenuItem getItemWithMaxPriceByType(String type) throws SQLException {
        String sql = "SELECT * FROM menu_items WHERE item_type = ? AND price = (SELECT MAX(price) FROM menu_items WHERE item_type = ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.setString(2, type);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapMenuItem(rs);
            }
        }
        return null;
    }

    // Task 4: Staff statistics
    public int getBaristaCount() throws SQLException {
        return getStaffCountByPosition("BARISTA");
    }

    public int getWaiterCount() throws SQLException {
        return getStaffCountByPosition("WAITER");
    }

    public int getConfectionerCount() throws SQLException {
        return getStaffCountByPosition("CONFECTIONER");
    }

    public int getTotalStaffCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM staff";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public Staff getLastHiredStaff() throws SQLException {
        String sql = "SELECT * FROM staff ORDER BY hire_date DESC LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapStaff(rs);
            }
        }
        return null;
    }

    public Staff getLongestWorkingStaff() throws SQLException {
        String sql = "SELECT * FROM staff ORDER BY hire_date ASC LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapStaff(rs);
            }
        }
        return null;
    }

    private int getStaffCountByPosition(String position) throws SQLException {
        String sql = "SELECT COUNT(*) FROM staff WHERE position = ?::position_type";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, position);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    // Task 5: Staff information queries
    public List<Staff> getStaffWithoutPhone() throws SQLException {
        List<Staff> staff = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE phone IS NULL OR phone = ''";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                staff.add(mapStaff(rs));
            }
        }
        return staff;
    }

    public List<String> getUniqueStaffFirstNames() throws SQLException {
        List<String> names = new ArrayList<>();
        String sql = "SELECT DISTINCT SPLIT_PART(full_name, ' ', 1) as first_name FROM staff ORDER BY first_name";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("first_name"));
            }
        }
        return names;
    }

    public List<String> getUniqueStaffLastNames() throws SQLException {
        List<String> names = new ArrayList<>();
        String sql = "SELECT DISTINCT SPLIT_PART(full_name, ' ', 2) as last_name FROM staff ORDER BY last_name";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("last_name"));
            }
        }
        return names;
    }

    // Task 1: Customer discount queries
    public double getMinCustomerDiscount() throws SQLException {
        String sql = "SELECT MIN(discount_percent) FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    public double getMaxCustomerDiscount() throws SQLException {
        String sql = "SELECT MAX(discount_percent) FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    public List<Customer> getCustomersWithMinDiscount() throws SQLException {
        return getCustomersWithDiscount("MIN");
    }

    public List<Customer> getCustomersWithMaxDiscount() throws SQLException {
        return getCustomersWithDiscount("MAX");
    }

    private List<Customer> getCustomersWithDiscount(String minOrMax) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE discount_percent = (SELECT " + minOrMax + "(discount_percent) FROM customers)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customers.add(mapCustomer(rs));
            }
        }
        return customers;
    }

    public double getAverageCustomerDiscount() throws SQLException {
        String sql = "SELECT AVG(discount_percent) FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    // Task 2: Customer age and birthday queries
    public Customer getYoungestCustomer() throws SQLException {
        String sql = "SELECT * FROM customers ORDER BY birth_date DESC LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapCustomer(rs);
            }
        }
        return null;
    }

    public Customer getOldestCustomer() throws SQLException {
        String sql = "SELECT * FROM customers ORDER BY birth_date ASC LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapCustomer(rs);
            }
        }
        return null;
    }

    public List<Customer> getCustomersWithBirthdayToday() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE EXTRACT(MONTH FROM birth_date) = EXTRACT(MONTH FROM CURRENT_DATE) " +
                    "AND EXTRACT(DAY FROM birth_date) = EXTRACT(DAY FROM CURRENT_DATE)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customers.add(mapCustomer(rs));
            }
        }
        return customers;
    }

    public List<Customer> getCustomersWithoutAddress() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE address IS NULL OR address = ''";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customers.add(mapCustomer(rs));
            }
        }
        return customers;
    }

    // Task 3: Order queries
    public List<Order> getOrdersByDate(LocalDate date) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE DATE(order_date) = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        }
        return orders;
    }

    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE DATE(order_date) BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(startDate));
            pstmt.setDate(2, Date.valueOf(endDate));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        }
        return orders;
    }

    public int getDessertOrdersCountByDate(LocalDate date) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders o " +
                    "JOIN order_items oi ON o.id = oi.order_id " +
                    "JOIN menu_items mi ON oi.menu_item_id = mi.id " +
                    "WHERE DATE(o.order_date) = ? AND mi.item_type = 'DESSERT'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public int getDrinkOrdersCountByDate(LocalDate date) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders o " +
                    "JOIN order_items oi ON o.id = oi.order_id " +
                    "JOIN menu_items mi ON oi.menu_item_id = mi.id " +
                    "WHERE DATE(o.order_date) = ? AND mi.item_type = 'DRINK'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    // Task 4: Customer and order statistics
    public List<CustomerOrderInfo> getCustomersWithDrinksToday() throws SQLException {
        List<CustomerOrderInfo> results = new ArrayList<>();
        String sql = "SELECT c.*, s.*, o.order_date, o.total_amount " +
                    "FROM customers c " +
                    "JOIN orders o ON c.id = o.customer_id " +
                    "JOIN staff s ON o.staff_id = s.id " +
                    "JOIN order_items oi ON o.id = oi.order_id " +
                    "JOIN menu_items mi ON oi.menu_item_id = mi.id " +
                    "WHERE DATE(o.order_date) = CURRENT_DATE AND mi.item_type = 'DRINK'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CustomerOrderInfo info = new CustomerOrderInfo();
                info.setCustomer(mapCustomer(rs));
                info.setStaff(mapStaff(rs));
                info.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                info.setTotalAmount(rs.getBigDecimal("total_amount"));
                results.add(info);
            }
        }
        return results;
    }

    public double getAverageOrderAmountByDate(LocalDate date) throws SQLException {
        String sql = "SELECT AVG(total_amount) FROM orders WHERE DATE(order_date) = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    public double getMaxOrderAmountByDate(LocalDate date) throws SQLException {
        String sql = "SELECT MAX(total_amount) FROM orders WHERE DATE(order_date) = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }

    public Customer getCustomerWithMaxOrderAmountByDate(LocalDate date) throws SQLException {
        String sql = "SELECT c.* FROM customers c " +
                    "JOIN orders o ON c.id = o.customer_id " +
                    "WHERE DATE(o.order_date) = ? " +
                    "AND o.total_amount = (SELECT MAX(total_amount) FROM orders WHERE DATE(order_date) = ?) " +
                    "LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            pstmt.setDate(2, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapCustomer(rs);
            }
        }
        return null;
    }

    // Task 5: Work schedule queries
    public List<WorkSchedule> getBaristaScheduleForWeek(Long baristaId, LocalDate weekStart) throws SQLException {
        return getStaffScheduleForWeek(baristaId, weekStart);
    }

    public List<WorkSchedule> getAllBaristasScheduleForWeek(LocalDate weekStart) throws SQLException {
        List<WorkSchedule> schedules = new ArrayList<>();
        LocalDate weekEnd = weekStart.plusDays(6);
        String sql = "SELECT ws.*, s.full_name, s.position " +
                "FROM work_schedule ws " +
                "JOIN staff s ON ws.staff_id = s.id " +
                "WHERE s.position = 'BARISTA'::position_type " +
                "AND ws.work_date BETWEEN ? AND ? " +
                "ORDER BY s.full_name, ws.work_date";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(weekStart));
            pstmt.setDate(2, Date.valueOf(weekEnd));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                schedules.add(mapWorkSchedule(rs));
            }
        }
        return schedules;
    }

    public List<WorkSchedule> getAllStaffScheduleForWeek(LocalDate weekStart) throws SQLException {
        List<WorkSchedule> schedules = new ArrayList<>();
        LocalDate weekEnd = weekStart.plusDays(6);
        String sql = "SELECT ws.*, s.full_name, s.position " +
                "FROM work_schedule ws " +
                "JOIN staff s ON ws.staff_id = s.id " +
                "WHERE ws.work_date BETWEEN ? AND ? " +
                "ORDER BY s.position, s.full_name, ws.work_date";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(weekStart));
            pstmt.setDate(2, Date.valueOf(weekEnd));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                schedules.add(mapWorkSchedule(rs));
            }
        }
        return schedules;
    }

    private List<WorkSchedule> getStaffScheduleForWeek(Long staffId, LocalDate weekStart) throws SQLException {
        List<WorkSchedule> schedules = new ArrayList<>();
        LocalDate weekEnd = weekStart.plusDays(6);
        String sql = "SELECT ws.*, s.full_name, s.position " +
                "FROM work_schedule ws " +
                "JOIN staff s ON ws.staff_id = s.id " +
                "WHERE ws.staff_id = ? " +
                "AND ws.work_date BETWEEN ? AND ? " +
                "ORDER BY ws.work_date";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, staffId);
            pstmt.setDate(2, Date.valueOf(weekStart));
            pstmt.setDate(3, Date.valueOf(weekEnd));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                schedules.add(mapWorkSchedule(rs));
            }
        }
        return schedules;
    }

    private MenuItem mapMenuItem(ResultSet rs) throws SQLException {
        MenuItem item = new MenuItem();
        item.setId(rs.getLong("id"));
        item.setNameEn(rs.getString("name_en"));
        item.setNameUa(rs.getString("name_ua"));
        item.setPrice(rs.getBigDecimal("price"));
        item.setItemType(rs.getString("item_type"));
        item.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return item;
    }

    private Staff mapStaff(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        staff.setId(rs.getLong("id"));
        staff.setFullName(rs.getString("full_name"));
        staff.setPosition(rs.getString("position"));
        staff.setPhone(rs.getString("phone"));
        staff.setHireDate(rs.getDate("hire_date").toLocalDate());
        staff.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return staff;
    }

    private Customer mapCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setFullName(rs.getString("full_name"));
        customer.setBirthDate(rs.getDate("birth_date").toLocalDate());
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setDiscountPercent(rs.getBigDecimal("discount_percent"));
        customer.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return customer;
    }

    private WorkSchedule mapWorkSchedule(ResultSet rs) throws SQLException {
        WorkSchedule schedule = new WorkSchedule();
        schedule.setId(rs.getLong("id"));
        schedule.setStaffId(rs.getLong("staff_id"));
        schedule.setWorkDate(rs.getDate("work_date").toLocalDate());
        schedule.setStartTime(rs.getTime("start_time").toLocalTime());
        schedule.setEndTime(rs.getTime("end_time").toLocalTime());
        schedule.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return schedule;
    }

    private Order mapOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setCustomerId(rs.getLong("customer_id"));
        order.setStaffId(rs.getLong("staff_id"));
        order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
        order.setTotalAmount(rs.getBigDecimal("total_amount"));
        order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return order;
    }

    public void addOrder(Long customerId, Long staffId, LocalDateTime orderDate, BigDecimal totalAmount) throws SQLException {
        String sql = "INSERT INTO orders (customer_id, staff_id, order_date, total_amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, customerId);
            pstmt.setLong(2, staffId);
            pstmt.setTimestamp(3, Timestamp.valueOf(orderDate));
            pstmt.setBigDecimal(4, totalAmount);
            pstmt.executeUpdate();
        }
    }
} 