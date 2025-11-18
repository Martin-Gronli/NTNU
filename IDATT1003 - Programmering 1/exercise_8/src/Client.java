public class Client {
    public static void main(String[] args) {
        //person objekt
        Person Martin = new Person("Martin", "Gronli", 2000);
        //employee objekt
        Employee MartinEmployee = new Employee(Martin, 50, 2020, 35000, 29);

        
        //printer infor om arbeidstaker
        System.out.println("--- Information ---");
        System.out.println("Name: " + MartinEmployee.getName());
        System.out.println("Age: " + MartinEmployee.getAge() + " år");
        System.out.println("Years employed: " + MartinEmployee.getYearsEmployed());
        System.out.println("Employed more than 10 years?: " + MartinEmployee.isEmployedMoreThan(10));

        //økonomiske beregninger
        System.out.println("\n--- Salary information");
        System.out.println("Gross monthly salary: " + MartinEmployee.getMonthlySalary());
        System.out.println("Tax each month: " + MartinEmployee.taxPerMonth());
        System.out.println("Gross yearly salary: " + MartinEmployee.yearlySalary());
        System.out.println("Tax per year: " + MartinEmployee.taxPerYear());



    }

}
