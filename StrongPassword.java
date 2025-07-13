package assignment2;

import java.util.Scanner;

public class StrongPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        // Prompt user to enter password
	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        // Check for criteria
	        boolean hasUpper = false;
	        boolean hasLower = false;
	        boolean hasDigit = false;
	        boolean hasSpecial = false;

	        for (char ch : password.toCharArray()) {
	            if (Character.isUpperCase(ch)) {
	                hasUpper = true;
	            } else if (Character.isLowerCase(ch)) {
	                hasLower = true;
	            } else if (Character.isDigit(ch)) {
	                hasDigit = true;
	            } else if (!Character.isLetterOrDigit(ch)) {
	                hasSpecial = true;
	            }
	        }

	        // Determine password strength
	        if (password.length() >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
	            System.out.println("Password strength: Strong.");
	        } else if (password.length() >= 6 && hasUpper && hasLower && hasDigit) {
	            System.out.println("Password strength: Medium.");
	        } else {
	            System.out.println("Password strength: Weak.");
	        }

	        scanner.close();
	}

}
