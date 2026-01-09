import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        
        System.out.println("--- Student Grade Tracker ---");
        System.out.println("Enter student grades (type -1 to finish):");

        while (true) {
            System.out.print("Enter grade: ");
            if (scanner.hasNextDouble()) {
                double grade = scanner.nextDouble();
                if (grade == -1) {
                    break;
                } else if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Please enter 0-100.");
                } else {
                    grades.add(grade);
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculations
            double sum = 0;
            for (double g : grades) {
                sum += g;
            }
            double average = sum / grades.size();
            double highest = Collections.max(grades);
            double lowest = Collections.min(grades);

            // Summary Report
            System.out.println("\n--- Grade Summary Report ---");
            System.out.println("Total Students: " + grades.size());
            System.out.printf("Average Score:  %.2f%n", average);
            System.out.println("Highest Score:  " + highest);
            System.out.println("Lowest Score:   " + lowest);
            System.out.println("All Grades:     " + grades);
        }
        
        scanner.close();
    }
}