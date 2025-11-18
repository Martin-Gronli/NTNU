import java.util.*;
//import java.util.Date; 

public class ArrangementRegister {
    private ArrayList<Arrangement> arrangements;

    public ArrangementRegister() {
        arrangements = new ArrayList<>();
    }

    public ArrayList<Arrangement> getArrangements() {
        return arrangements;
    }

    public void registerArrangement(Arrangement arrangement) {
        arrangements.add(arrangement);
    }

    public ArrayList<Arrangement> getArrangementsByLocation(String location) {
        ArrayList<Arrangement> result = new ArrayList<>();
        for (Arrangement arrangement : arrangements) {
            if (arrangement.getLocation().equalsIgnoreCase(location)) {
                result.add(arrangement);
            }
        }
        return result;
    }

    public ArrayList<Arrangement> getArrangementsByTime(long time) {
        ArrayList<Arrangement> result = new ArrayList<>();
        for (Arrangement arrangement : arrangements) {
            if (arrangement.getTime() == time) {
                result.add(arrangement);
            }
        }
        return result;
    }

    public ArrayList<Arrangement> getArrangementsBetweenTimes(long startTime, long endTime) {
        ArrayList<Arrangement> result = new ArrayList<>();
        for (Arrangement arrangement : arrangements) {
            if (arrangement.getTime() >= startTime && arrangement.getTime() <= endTime) {
                result.add(arrangement);
            }
        }
        return result;
    }
    
    public void AllArrangements(int choice) {
        switch (choice) {
            case 1 -> {
                for (Arrangement arrangement : arrangements) {
                    System.out.println(arrangement.getLocation());
                }
            }
            case 2 -> {
                for (Arrangement arrangement : arrangements) {
                    System.out.println(arrangement.getType());
                }
            }
            case 3 -> {
                for (Arrangement arrangement : arrangements) {
                    System.out.println(arrangement.getTime());
                }
            }
            default -> System.out.println("Invalid choice");

        }
    }
}