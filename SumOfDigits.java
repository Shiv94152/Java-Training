package assignment2;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        // Ask the user to enter an integer
	        System.out.print("Enter an integer: ");
	        int number = scanner.nextInt();
	        int original = number;  // Store the original number
	        int sum = 0;

	        // Make sure number is positive for digit extraction
	        number = Math.abs(number);

	        // Calculate sum of digits
	        while (number != 0) {
	            int digit = number % 10;  // Extract last digit
	            sum += digit;             // Add digit to sum
	            number /= 10;             // Remove last digit
	        }

	        // Display the result
	        System.out.println("The number is "+ original +".");
	        System.out.println("The sum of the digits is " + sum + ".");

	        scanner.close();
	}

}
