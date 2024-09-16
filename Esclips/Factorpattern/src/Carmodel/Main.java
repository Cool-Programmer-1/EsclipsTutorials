package Carmodel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carfactory carFactory = new Carfactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 1 for Toyota car price");
        System.out.println("Press 2 for Audi car price");
        System.out.println("Press 3 for Range Rover car price");
      
        int choice = scanner.nextInt();
        car car = carFactory.getCar(choice);

        if (car != null) {
            System.out.println("The price of the selected car is: $" + car.getPrice());
        } else {
            System.out.println("Invalid choice. Please select either 1, 2, 3, or 4.");
        }

        scanner.close();
    }
}
