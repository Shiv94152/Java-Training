package assignment2;

import java.util.Scanner;

public class TriangleType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the sides of the triangle
        System.out.print("Enter the first side: ");
        int side1 = scanner.nextInt();

        System.out.print("Enter the second side: ");
        int side2 = scanner.nextInt();

        System.out.print("Enter the third side: ");
        int side3 = scanner.nextInt();

        // Check if the sides can form a triangle
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            // Determine the type of triangle
            if (side1 == side2 && side2 == side3) {
                System.out.println("The triangle is equilateral.");
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                System.out.println("The triangle is isosceles.");
            } else {
                System.out.println("The triangle is scalene.");
            }
        } else {
            System.out.println("The entered sides do not form a valid triangle.");
        }

        scanner.close();
	}

}
