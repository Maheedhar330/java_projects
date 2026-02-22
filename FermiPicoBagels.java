
import java.util.Scanner;

public class FermiPicoBagels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // You can change this to any number (as string)
        String originalNumber = "5489";
        
        System.out.println("Guess the " + originalNumber.length() + "-digit number!");
        System.out.println("(No duplicate digits allowed)\n");
        
        while (true) {
            System.out.print("Guess the number: ");
            String guessNumber = scanner.nextLine().trim();
            
            // Check length
            if (guessNumber.length() != originalNumber.length()) {
                System.out.println("Enter " + originalNumber.length() + " digit number");
                continue;
            }
            
            // Check for duplicate digits
            if (hasDuplicateDigits(guessNumber)) {
                System.out.println("Duplicate number not allowed");
                continue;
            }
            
            // Correct guess - win condition
            if (guessNumber.equals(originalNumber)) {
                System.out.println(" Fermi".repeat(originalNumber.length()));
                System.out.println("\nYou won!!");
                break;
            }
            
            // Build result
            StringBuilder output = new StringBuilder();
            
            for (int i = 0; i < originalNumber.length(); i++) {
                for (int j = 0; j < guessNumber.length(); j++) {
                    if (originalNumber.charAt(i) == guessNumber.charAt(j)) {
                        if (i == j) {
                            output.append(" Fermi");
                        } else {
                            output.append(" Pico");
                        }
                    }
                }
            }
            
            // Print result
            if (output.length() == 0) {
                System.out.println("Bagels");
            } else {
                System.out.println(output.toString().trim());
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    // Helper method to check if string has duplicate characters
    private static boolean hasDuplicateDigits(String s) {
        boolean[] seen = new boolean[10];   // digits 0-9
        
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return true;  // non-digit → treat as invalid (duplicate check fails)
            }
            int digit = c - '0';
            if (seen[digit]) {
                return true;
            }
            seen[digit] = true;
        }
        return false;
    }
}
