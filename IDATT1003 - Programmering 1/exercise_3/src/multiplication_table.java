import java.util.*;

public class multiplication_table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter desired multiplication table:");
        int table = in.nextInt();
        System.out.println("Enter range:");
        int range = in.nextInt();

        for (int i = 1; i <= range; i++) {
            System.out.println(table + " * " + i + " = " + (table * i));
        in.close();
        }
        
    }
    
}
