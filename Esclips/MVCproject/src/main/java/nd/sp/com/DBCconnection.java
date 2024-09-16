package nd.sp.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCconnection {
    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/yt_demo"; // MySQL URL followed by the database name
        String username = "root"; // MySQL username
        String password = "Shamshad1@"; // MySQL password
        System.out.println("In DBConnection.java class");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL drivers
            con = DriverManager.getConnection(url, username, password); // Attempting to connect to MySQL database
            System.out.println("Printing connection object " + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
