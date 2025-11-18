import java.util.*;
class hrs_min_sec_to_sec {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter hours, minutes and seconds:");
            double hrs = in.nextDouble();
            double min = in.nextDouble();
            double sec = in.nextDouble();
            double total_sec = (hrs * 3600) + (min * 60) + sec;
            System.out.println("Total seconds: " + total_sec);
        }
    
    }
    
}
