import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //scanner objekt
        Scanner in = new Scanner(System.in);
        System.out.println("Input first name: ");
        String navn = in.nextLine();
        System.out.println("Input last name: ");
        String etternavn = in.nextLine();
        System.out.println("Input birthyear: ");
        int year = in.nextInt();

        
        //person objekt
        Person Martin = new Person(navn, etternavn, year);
        
        
        //employee objekt
        Employee MartinEmployee = new Employee(Martin, 50, 2020, 35000, 29);

    }   

}