package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Shamshad12 {

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
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS bright";
            stm.execute(createDatabaseQuery);
            System.out.println("Database created successfully");

            // Connect to the new database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/light?useSSL=false", userName, password);
            stm = conn.createStatement();

            // Create the table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                                      "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                      "name VARCHAR(100), " +
                                      "email VARCHAR(100))";
            stm.execute(createTableQuery);
            System.out.println("Table created successfully");

            // Get user input
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            // Insert data into the table
            String insertDataQuery = "INSERT INTO users (name, email) VALUES ('" + name + "', '" + email + "')";
            stm.executeUpdate(insertDataQuery);
            System.out.println("Data inserted successfully");

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
