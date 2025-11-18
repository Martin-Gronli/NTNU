public class Arrangement {
    private final int id;
    private String name, location, type, organizer;
    private long time; // YYYYMMDDHHMM

    public Arrangement(int id, String name, String location, String type, String organizer, long time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.organizer = organizer;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", organizer='" + organizer + '\'' +
                ", time=" + time +
                '}';
    } 
}

