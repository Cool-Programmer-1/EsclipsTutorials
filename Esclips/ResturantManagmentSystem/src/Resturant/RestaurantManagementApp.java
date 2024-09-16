package Resturant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bright";
    private static final String USER = "root";
    private static final String PASSWORD = "Shamshad1@";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

class Restaurant {
    private String name;
    private String location;
    private String cuisine;

    public Restaurant(String name, String location, String cuisine) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
    }

    public void save() {
        String sql = "INSERT INTO restaurant (name, location, cuisine) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.name);
            pstmt.setString(2, this.location);
            pstmt.setString(3, this.cuisine);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
}

class Menu {
    private int restaurantId;
    private String itemName;
    private double price;

    public Menu(int restaurantId, String itemName, double price) {
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.price = price;
    }

    public void save() {
        String sql = "INSERT INTO menu (restaurant_id, item_name, price) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.restaurantId);
            pstmt.setString(2, this.itemName);
            pstmt.setDouble(3, this.price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
}

public class RestaurantManagementApp {
    public static void main(String[] args) {
        // Add a new restaurant
        Restaurant restaurant = new Restaurant("Gourmet Paradise", "123 Main St", "Italian");
        restaurant.save();

        // Add a menu item for the restaurant
        Menu menu = new Menu(1, "Spaghetti Carbonara", 12.50);
        menu.save();
    }
}
