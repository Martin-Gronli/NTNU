import java.util.*; 

public class RandomCounter {
     
    public RandomCounter() {

    } 
public static void main(String[] args) {
    Random r = new Random();
    int[] number = new int[10];
    int rounds = 50000;

    for (int i = 0; i <= rounds; i++) {
        int num = r.nextInt(10); number[num]++; 
    }

    System.out.println("Result after " + rounds + " rounds:"); 
    
    for (int n = 0; n < number.length; n++) { 
        System.out.println("Number " + n + ":" + number[n]); 
    }

  }

}