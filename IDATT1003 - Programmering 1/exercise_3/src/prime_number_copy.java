import javax.swing.JOptionPane;

public class prime_number_copy {
    public static void main(String[] args) {
        boolean continueLoop = true;
        
        while (continueLoop) { // Loop until user decides to exit
            String input = JOptionPane.showInputDialog(null, "Enter a number (or 0 to exit)"); // Read user input
            if (input == null) { // Handle cancel button
                break;
            }
            
            try {
                int num = Integer.parseInt(input); // Convert input to integer

                if (num == 0) { // Exit condition
                    break;
                }
                
                boolean isPrime = true; // Assume integer is prime unless proven otherwise
                if (num <= 1) { 
                    isPrime = false;
                } else { // Check for factors from 2 up to the square root of the integer
                    for (int i = 2; i <= Math.sqrt(num); i++) { 
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
            
                if (isPrime) {
                    JOptionPane.showMessageDialog(null, num + " is a prime number");
                } else {
                    JOptionPane.showMessageDialog(null, num + " is not a prime number");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
     }
    }

}