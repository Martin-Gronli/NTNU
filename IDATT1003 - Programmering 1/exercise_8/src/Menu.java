import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //testobjekter
        Person person = new Person("Arvid", "Hansen", 1980);
        Employee employee = new Employee(person, 432, 2010, 55000, 29);


        boolean runProgram = true;

        while (runProgram) {
            System.out.println("\n=== Menu ===");
            System.out.println("1: Show employee info");
            System.out.println("2: Show economic calculations");
            System.out.println("3: Change monthly salary");
            System.out.println("4: Change tax percentage");
            System.out.println("5: Exit");
            System.out.print("Choose an alternative: ");


            int choice = in.nextInt();

            switch (choice) {

                case 1 -> {
                    //vis all info
                    System.out.println("\n" + employee);
                    System.out.println("Age: " + employee.getAge());
                    System.out.println("Years employed: " + employee.getYearsEmployed());
                    System.out.println("Employed more than 10 years?:" + employee.isEmployedMoreThan(10));
                }

                case 2 -> {
                    //vis økonomiske beregninger
                    System.out.println("\nGross monthly salary: " + employee.getMonthlySalary());
                    System.out.println("Tax each month: " + employee.taxPerMonth());
                    System.out.println("Gross yearly salary: " + employee.yearlySalary());
                    System.out.println("Tax per year: " + employee.taxPerYear());
                }

                case 3 -> {
                    //endre månedslønn
                    System.out.println("\nInput new monthly salary: ");
                    double newSalary = in.nextDouble();
                    employee.setMonthlySalary(newSalary);
                    System.out.println("New monthly salary is set to: " + employee.getMonthlySalary());
                }

                case 4 -> {
                    //endre skatteprosent
                    System.out.println("\nInput new tax percentage: ");
                    double newTax = in.nextDouble();
                    employee.setTaxPercentage(newTax);
                    System.out.println("New tax percentage is set to: " + employee.getTaxPercentage());
                }

                case 5 -> {
                    //avslutt
                    System.out.println("\nExiting program...");
                    runProgram = false;
                }

                default -> System.out.println("\nInvalid choice, try again");


            }
        }

        in.close();

    }   

}