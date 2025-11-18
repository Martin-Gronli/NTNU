import java.util.*;

public class Klient {
    public Scanner in = new Scanner(System.in);

    public Register register = new Register();

    public void testData() {
        Tomt tomt1 = new Tomt(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen");
        Tomt tomt2 = new Tomt(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        Tomt tomt3 = new Tomt(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        Tomt tomt4 = new Tomt(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten");
        Tomt tomt5 = new Tomt(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

        register.leggTilTomt(tomt1);
        register.leggTilTomt(tomt2);
        register.leggTilTomt(tomt3);
        register.leggTilTomt(tomt4);
        register.leggTilTomt(tomt5);
    }

    public static void main(String[] args) {
        Klient klient = new Klient();
        klient.testData();
        while (true) { 
            klient.meny();
        }
    }
    public void meny() {
        System.out.println("\n--- Tomteregister Meny ---");
        System.out.println("1. Legg til tomt");
        System.out.println("2. Skriv ut alle tomter");
        System.out.println("3. Finn tomt");
        System.out.println("4. Regn ut gjennomsnittlig areal");
        System.out.println("5. Avslutt");
        System.out.print("Velg et alternativ (1-5): ");

        int valg = in.nextInt();
        switch (valg) {
            case 1:
                System.out.println(leggTilTomt());
                break;
            case 4:
                register.gjenomsnittAreal();
                break;
            case 3:
                finnTomt();
                break;
            case 2:
                printAlleTomter();
                break;
            case 5:
                System.out.println("Avslutter programmet. Ha en fin dag!");
                System.exit(0);
            default:
                System.out.println("Ugyldig valg. Vennligst prøv igjen.");
        }
    }

    public String leggTilTomt() {
        System.out.print("Oppgi kommuneNr: ");
        int kommuneNr = in.nextInt();
        in.nextLine(); //konsumere linjeskift

        System.out.print("Oppgi kommuneNavn: ");
        String kommuneNavn = in.nextLine();

        System.out.print("Oppgi gårdsNr: ");
        int gårdsNr = in.nextInt();

        System.out.print("Oppgi bruksNr: ");
        int bruksNr = in.nextInt();
        in.nextLine(); //konsumere linjeskift
        
        System.out.print("Oppgi navn: ");
        String navn = in.nextLine();

        System.out.print("Oppgi areal: ");
        double areal = in.nextDouble();
        in.nextLine(); //konsumere linjeskift

        System.out.print("Oppgi eier: ");
        String eier = in.nextLine(); 

        try {
            Tomt nyTomt = new Tomt(kommuneNr, kommuneNavn, gårdsNr, bruksNr, navn, areal, eier);
            register.leggTilTomt(nyTomt);
            return "Tomt lagt til: " + nyTomt.toString();
        } catch (IllegalArgumentException e) {
            // Ikke la programmet krasje; informer brukeren om hva som gikk galt
            return "Kunne ikke legge til tomt: " + e.getMessage();
        }
    }

    public String finnTomt() {
        System.out.print("Oppgi kommuneNr: ");
        int kommuneNr = in.nextInt();
        System.out.print("Oppgi gårdsNr: ");
        int gårdsNr = in.nextInt();
        System.out.print("Oppgi bruksNr: ");
        int bruksNr = in.nextInt();
        // Register.finnTomt skriver ut resultatet direkte, så vi kaller den og returnerer en statusmelding
        register.finnTomt(kommuneNr, gårdsNr, bruksNr);
        return "Søk utført.";
    }

    public String printAlleTomter() {
        // Register.getAlleTomter skriver ut alle tomter direkte
        register.getAlleTomter();
        return "Listet alle tomter.";
    }

}