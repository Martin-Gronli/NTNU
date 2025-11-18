import java.util.*;
public class TaskOverview {
    public ArrayList<Student> students = new ArrayList<>();
    //private int totalStudents = 0;

    public TaskOverview() { //constructor that initializes the list of students
        this.students = new ArrayList<>();
    }

    public int getStudentsRegistered() { //returns the number of registered students
        return students.size();
    }

    public int getTotalTasksStudent(Student student) { //returns the total number of tasks completed by a specific student
        return student.getTasks();
    }

    public void registerStudent(Student student) { //registers a new student
        for (Student existingStudent : students) {
            if (existingStudent.getName().equals(student.getName())) {
                return; // Student already registered
            }
        }

        students.add(student);
    }

    public void incrementSpecificStudentTasks(Student student, int increment) { //increments the number of tasks completed by a specific student
        student.incrementTasks(increment);
    }

}