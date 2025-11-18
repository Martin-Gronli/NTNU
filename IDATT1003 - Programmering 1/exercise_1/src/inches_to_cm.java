import java.util.*;
class inches_to_cm {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter value in inches: ");
            double inches = in.nextDouble();
            double inch = 2.54;
            double result = inch * inches;
            System.out.println("Value in cm: " + result);
        }
    
    }

}