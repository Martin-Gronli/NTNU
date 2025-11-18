import java.util.*;

public class FractionCalc {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter numerator for fraction a:");
            int n1 = sc.nextInt();
            
            System.out.println("Enter denominator for fraction a:");
            int d1 = sc.nextInt();
            
            Fraction a = new Fraction(n1, d1);
            
            System.out.println("Enter numerator for fraction b:");
            int n2 = sc.nextInt();
            
            System.out.println("Enter numerator for fraction b:");
            int d2 = sc.nextInt();
            
            Fraction b = new Fraction(n2, d2);
            
            System.out.println("Choose operation (+, -, *, /): ");
            String op = sc.next();
            
            switch (op) {
                case "+" -> a.add(b);
                case "-" -> a.sub(b);
                case "*" -> a.mul(b);
                case "/" -> a.div(b);
                default -> {
                    System.out.println("invalid operator.");
                    sc.close();
                    return;
                }  
            }
            
            System.out.println("The result is: " + a);
        }

    }

}