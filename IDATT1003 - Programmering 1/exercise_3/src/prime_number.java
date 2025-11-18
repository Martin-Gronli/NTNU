import java.util.*;

public class prime_number {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            boolean continueLoop = true;
            
            while (continueLoop) { // Loop until user decides to exit
                System.out.println("Enter a number (or 0 to exit):"); // Prompt user for input
                int num = in.nextInt(); // Read user input
                
                if (num == 0) { // Exit condition
                    //continueLoop = false;
                    break;
                }
                
                boolean isPrime = true; // Assume integer is prime unless proven otherwise
                if (num <= 1) {
                    isPrime = false;
                }   else { // Check for factors from 2 up to the square root of the integer
                    for (int i = 2; i <= Math.sqrt(num); i++) { 
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                
                if (isPrime) {
                    System.out.println(num + " is a prime number");
                }   else {
                    System.out.println(num + " is not a prime number");
                }
            }   }
    }

}