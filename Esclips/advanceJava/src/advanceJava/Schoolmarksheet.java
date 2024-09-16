package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int[] getMarks() {
        return marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
}

public class Schoolmarksheet {
    private List<Student> students;
    private Connection connection;

    public Schoolmarksheet() {
        students = new ArrayList<>();
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/light", "root", "Shamshad1@");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentToDatabase(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.print("Marks: ");
            for (int mark : student.getMarks()) {
                System.out.print(mark + " ");
            }
            System.out.println("\nAverage: " + student.calculateAverage());
            System.out.println();
        }
    }

    private void saveStudentToDatabase(Student student) {
        String query = "INSERT INTO students (name, roll_number, marks) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getRollNumber());
            preparedStatement.setString(3, convertMarksToString(student.getMarks()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String convertMarksToString(int[] marks) {
        StringBuilder marksString = new StringBuilder();
        for (int mark : marks) {
            marksString.append(mark).append(",");
        }
        return marksString.toString();
    }

    public static void main(String[] args) {
        Schoolmarksheet markSheet = new Schoolmarksheet();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students (at least 12):");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter name for student " + (i + 1) + ":");
            String name = scanner.nextLine();

            System.out.println("Enter roll number for student " + (i + 1) + ":");
            int rollNumber = scanner.nextInt();

            System.out.println("Enter number of subjects:");
            int numberOfSubjects = scanner.nextInt();
            int[] marks = new int[numberOfSubjects];

            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println("Enter marks for subject " + (j + 1) + ":");
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            markSheet.addStudent(new Student(name, rollNumber, marks));
        }

        markSheet.displayStudents();
        scanner.close();
    }
}
