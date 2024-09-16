package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Shamshad123 {

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
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS Sun1";
            stm.execute(createDatabaseQuery);
            System.out.println("Database created successfully");

            // Connect to the new database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sun1?useSSL=false", userName, password);
            stm = conn.createStatement();

            // Create the tables
            String createUsersTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                                           "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                           "name VARCHAR(100), " +
                                           "email VARCHAR(100))";
            stm.execute(createUsersTableQuery);
            System.out.println("Users table created successfully");

            String createCoursesTableQuery = "CREATE TABLE IF NOT EXISTS courses (" +
                                             "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                             "course_name VARCHAR(100), " +
                                             "course_code VARCHAR(10))";
            stm.execute(createCoursesTableQuery);
            System.out.println("Courses table created successfully");

            String createEnrollmentsTableQuery = "CREATE TABLE IF NOT EXISTS enrollments (" +
                                                 "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                                 "user_id INT, " +
                                                 "course_id INT, " +
                                                 "FOREIGN KEY (user_id) REFERENCES users(id), " +
                                                 "FOREIGN KEY (course_id) REFERENCES courses(id))";
            stm.execute(createEnrollmentsTableQuery);
            System.out.println("Enrollments table created successfully");

            // Get user input
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            // Insert data into the users table
            String insertUserDataQuery = "INSERT INTO users (name, email) VALUES ('" + name + "', '" + email + "')";
            stm.executeUpdate(insertUserDataQuery);
            System.out.println("User data inserted successfully");

            // Get course input
            System.out.print("Enter branch name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter course name: ");
            String courseCode = scanner.nextLine();

            // Insert data into the courses table
            String insertCourseDataQuery = "INSERT INTO courses (course_name, course_code) VALUES ('" + courseName + "', '" + courseCode + "')";
            stm.executeUpdate(insertCourseDataQuery);
            System.out.println("Course data inserted successfully");

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
