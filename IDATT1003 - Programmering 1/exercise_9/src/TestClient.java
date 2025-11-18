import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskOverview overview = new TaskOverview();

        while (true) {
            System.out.println("1. Register student");
            System.out.println("2. Increment student tasks");
            System.out.println("3. View all students and tasks");
            System.out.println("4. View total tasks for a student");
            System.out.println("5. Show overview of students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = in.next();
                    overview.registerStudent(new Student(name));
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String incName = in.next();
                    System.out.print("Enter number of tasks to increment: ");
                    int increment = in.nextInt();
                    for (Student student : overview.students) {
                        if (student.getName().equals(incName)) {
                            overview.incrementSpecificStudentTasks(student, increment);
                            break;
                        }
                    }
                    break;

                case 3:
                    for (Student student : overview.students) {
                        System.out.println(student);
                    }
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    String taskName = in.next();
                    for (Student student : overview.students) {
                        if (student.getName().equals(taskName)) {
                            System.out.println("Total tasks: " + overview.getTotalTasksStudent(student));
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Total registered students: " + overview.getStudentsRegistered());
                    break;

                case 6:
                    in.close();
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}