    public class Student {
    private String name;
    private int tasks;

    public Student(String name) { //constructor that initializes the student's name and sets tasks to 0
        this.name = name;
        this.tasks = 0;
    }

    public String getName() { //returns the name of the student
        return name;
    }

    public int getTasks() { //returns the number of tasks completed by the student
        return tasks;
    }

    public void incrementTasks(int increment) { //increments the number of tasks completed by the student
        this.tasks += increment;
    }

    @Override
    public String toString() {
        return this.name + " " + this.tasks;
    }        
}
