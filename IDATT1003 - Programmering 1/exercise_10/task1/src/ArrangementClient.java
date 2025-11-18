import java.util.Scanner;

public class ArrangementClient {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrangementRegister register = new ArrangementRegister();

        // hardcoded sample arrangements
        register.registerArrangement(new Arrangement(1, "Concert", "Oslo", "Music", "ABC Events", 202406151900L));
        register.registerArrangement(new Arrangement(2, "Art Exhibition", "Bergen", "Art", "XYZ Gallery", 202406201200L));
        register.registerArrangement(new Arrangement(3, "Tech Conference", "Oslo", "Technology", "TechWorld", 202407011000L));
        register.registerArrangement(new Arrangement(4, "Food Festival", "Stavanger", "Food", "Gourmet Events", 202407151200L));
        register.registerArrangement(new Arrangement(5, "Book Fair", "Trondheim", "Literature", "Readers Club", 202408051000L));

        while (true) {
        System.out.println("Choose an option:");
        System.out.println("1. Register new arrangement");
        System.out.println("2. Find arrangements by location");
        System.out.println("3. Find arrangements by date");
        System.out.println("4. Find arrangements between dates");
        System.out.println("5. List all arrangements");
        System.out.println("6. Exit");

        int choice = in.nextInt();

        switch (choice) {
            case 1 -> {
                // Register new arrangement
                System.out.print("Enter ID: ");
                int id = in.nextInt();
                in.nextLine();  // Consume newline
                System.out.print("Enter title: ");
                String title = in.nextLine();
                System.out.print("Enter location: ");
                String location = in.nextLine();
                System.out.print("Enter type: ");
                String type = in.nextLine();
                System.out.print("Enter organizer: ");
                String organizer = in.nextLine();
                System.out.print("Enter date (YYYYMMDDHHMM): ");
                long date = in.nextLong();

                register.registerArrangement(new Arrangement(id, title, location, type, organizer, date));
                System.out.println("Arrangement registered successfully.");
            }
            case 2 -> {
                // Find arrangements by location
                System.out.print("Enter location: ");
                in.nextLine();  // Consume newline
                String loc = in.nextLine();
                var arrangementsByLocation = register.getArrangementsByLocation(loc);
                for (Arrangement arr : arrangementsByLocation) {
                    System.out.println(arr.getName() + " at " + arr.getLocation() + " on " + arr.getTime());
                }
            }
            case 3 -> {
                // Find arrangements by date
                System.out.print("Enter date (YYYYMMDDHHMM): ");
                long date = in.nextLong();
                var arrangementsByTime = register.getArrangementsByTime(date);
                for (Arrangement arr : arrangementsByTime) {
                    System.out.println(arr.getName() + " at " + arr.getLocation() + " on " + arr.getTime());
                }
            }
            case 4 -> {
                // Find arrangements between dates
                System.out.print("Enter start date (YYYYMMDDHHMM): ");
                long startTime = in.nextLong();
                System.out.print("Enter end date (YYYYMMDDHHMM): ");
                long endTime = in.nextLong();
                var arrangementsBetweenTimes = register.getArrangementsBetweenTimes(startTime, endTime);
                for (Arrangement arr : arrangementsBetweenTimes) {
                    System.out.println(arr.getName() + " at " + arr.getLocation() + " on " + arr.getTime());
                }
            }
            case 5 -> {
                System.out.println("List over all arrangements: 1. By location 2. By type 3. Between times");
                System.out.print("Enter choice (1-3): ");
                int listChoice = in.nextInt();
                register.AllArrangements(listChoice);
            }
            case 6 -> {
                System.out.println("Exiting...");
                in.close();
                return;
            }
            default -> throw new AssertionError();
        }
        }
    }
}