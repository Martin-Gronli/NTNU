import java.util.*;
class sec_to_hrs_min_sec {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter seconds:");
            int totalSec = in.nextInt();
            
            int hrs = totalSec/3600;
            int min = (totalSec%3600)/60;
            int sec = totalSec%60;
            
            System.out.println(hrs + " hours " + min + " minutes " + sec + " seconds");
        }
    
    }
    
}