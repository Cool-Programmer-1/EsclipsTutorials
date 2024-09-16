package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/customer"; // MySQL URL followed by the database name
        String username = "root"; // MySQL username
        String password = "Shamshad1@"; // MySQL password
        
        System.out.println("In DBConnection.java class");

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver"); // Loading MySQL drivers. This differs for database servers
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            con = DriverManager.getConnection(url, username, password); // Attempting to connect to MySQL database
            System.out.println("Printing connection object " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
