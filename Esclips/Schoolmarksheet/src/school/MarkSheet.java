package school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarkSheet {
    private List<Student> students;

    public MarkSheet() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
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

    public static void main(String[] args) {
        MarkSheet markSheet = new MarkSheet();
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
