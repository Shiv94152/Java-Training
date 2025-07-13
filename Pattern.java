package assignment2;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; // Number of rows for the top half (including center row)

        // Print the top half of the pattern
        for (int i = 1; i <= n; i++) {
            int stars = 2 * i - 1; // Number of stars in the current row
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Print the bottom half of the pattern
        for (int i = n - 1; i >= 1; i--) {
            int stars = 2 * i - 1; // Number of stars in the current row
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
	}

}
