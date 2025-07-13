package assignment2;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        // Prompt user to enter an integer
	        System.out.print("Enter an integer: ");
	        int number = scanner.nextInt();

	        // Check if the number is prime
	        boolean isPrime = true;

	        if (number <= 1) {
	            isPrime = false; // Numbers less than or equal to 1 are not prime
	        } else {
	            // Check for divisibility from 2 to sqrt(number)
	            for (int i = 2; i <= Math.sqrt(number); i++) {
	                if (number % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }

	        // Output the result
	        if (isPrime) {
	            System.out.println(number + " is a prime number.");
	        } else {
	            System.out.println(number + " is not a prime number.");
	        }

	        scanner.close();
	}

}
