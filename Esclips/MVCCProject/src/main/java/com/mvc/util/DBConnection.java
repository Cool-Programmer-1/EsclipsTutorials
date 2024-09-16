package com.mvc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/RegisterDB"; // MySQL URL followed by the database name
        String username = "root"; // MySQL username
        String password = "Shamshad1@"; // MySQL password
        System.out.println("In DBConnection.java class");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loading MySQL drivers. This differs for database servers
            System.out.println("MySQL JDBC Driver Registered!");
            con = DriverManager.getConnection(url, username, password); // attempting to connect to MySQL database
            System.out.println("Printing connection object " + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed! Check output console.");
        }

        if (con == null) {
            System.out.println("Failed to make connection!");
        }

        return con;
    }
}
