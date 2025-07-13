package assignment2;

import java.util.Scanner;

public class ReverseOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner scanner = new Scanner(System.in);

	        // Ask the user to enter an integer
	        System.out.print("Enter an integer: ");
	        int number = scanner.nextInt();
	        int original = number;  // Store the original number
	        int reversed = 0;

	        // Reverse the digits
	        while (number != 0) {
	            int digit = number % 10;      // Get the last digit
	            reversed = reversed * 10 + digit; // Add it to the reversed number
	            number /= 10;                 // Remove the last digit
	        }

	        // Display the result
	        System.out.println("The original number is "+ original +".");
	        System.out.println("The reversed number is " + reversed + ".");

	        scanner.close();
	}

}
