package assignment2;
import java.util.Scanner;
public class GradeSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner scanner = new Scanner(System.in);

		        // Prompt user for input
		        System.out.print("Enter your score (0-100): ");
		        int score = scanner.nextInt();

		        // Check if score is within the valid range
		        if (score < 0 || score > 100) {
		            System.out.println("Invalid score. Please enter a number between 0 and 100.");
		        } else {
		            // Determine grade
		            char grade;
		            if (score >= 90) {
		                grade = 'A';
		            } else if (score >= 80) {
		                grade = 'B';
		            } else if (score >= 70) {
		                grade = 'C';
		            } else if (score >= 60) {
		                grade = 'D';
		            } else {
		                grade = 'F';
		            }

		            // Output result
		            System.out.println("Your grade is " + grade + ".");
		        }

		        scanner.close();
		    }
		

	

}
