import java.time.LocalDate;

public class Employee {
    private final Person personalia;
    private final int employeeNumber;
    private final int yearOfEmployment;
    private double monthlySalary;
    private double taxPercentage;

    public Employee(Person personalia, int employeeNumber, int yearOfEmployment, double monthlySalary, double taxPercentage) {
        this.personalia = personalia;
        this.employeeNumber = employeeNumber;
        this.yearOfEmployment = yearOfEmployment;
        this.monthlySalary = monthlySalary;
        this.taxPercentage = taxPercentage;
    }
    
    //get-metoder for alle attributter

    public Person getPersonalia() {
        return personalia;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getYearOfEmployment() {
        return yearOfEmployment;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
    
    public double getTaxPercentage() {
        return taxPercentage;
    }

    //set-metoder for de som bør endres

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    //operasjoner

    public double taxPerMonth() {
        return  monthlySalary * (taxPercentage / 100);
    }

    public double yearlySalary() {
        return monthlySalary * 12;
    }

    public double taxPerYear() {
        double fullTax = taxPerMonth();
        return fullTax * 10.5;
    }

    public String getName() {
        return personalia.getLastName() + ", " + personalia.getFirstName();
    }

    public int getAge() {
        int yearNow = LocalDate.now().getYear();
        return yearNow - personalia.getBirthYear();
    }

    public int getYearsEmployed() {
        int yearNow = LocalDate.now().getYear();
        return yearNow - yearOfEmployment;
    }

    public boolean isEmployedMoreThan(int amountYears) {
        return getYearsEmployed() > amountYears;

    }

    @Override
    public String toString() {
        return 
            "Employee nr: " + employeeNumber + "\n" +
            "Name: " + getName() + "\n" +
            "Employment year: " + yearOfEmployment + "\n" +
            "Monthly salary: " + monthlySalary + "\n" +
            "Tax percentage: " + taxPercentage + "%";
    
    }




}
