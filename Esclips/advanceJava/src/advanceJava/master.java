package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class master {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stm = null;
        Scanner scanner = new Scanner(System.in);

        try {
            String url = "jdbc:mysql://localhost:3306/sam?useSSL=false";
            String userName = "root";
            String password = "Shamshad1@";
            conn = DriverManager.getConnection(url, userName, password);
            stm = conn.createStatement();

            // Create the database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS bee";
            stm.execute(createDatabaseQuery);
            System.out.println("Database created successfully");

            // Connect to the new database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bee?useSSL=false", userName, password);
            stm = conn.createStatement();

            // Create the users table
            String createUsersTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                                           "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                           "name VARCHAR(100), " +
                                           "email VARCHAR(100))";
            stm.execute(createUsersTableQuery);
            System.out.println("Users table created successfully");

            // Get user input
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            // Insert data into the users table
            String insertUserDataQuery = "INSERT INTO users (name, email) VALUES ('" + name + "', '" + email + "')";
            stm.executeUpdate(insertUserDataQuery);
            System.out.println("User data inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
