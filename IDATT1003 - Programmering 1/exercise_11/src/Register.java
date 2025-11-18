import java.util.ArrayList;

public class Register {
    private ArrayList<Tomt> tomter;

    public Register() {
        tomter = new ArrayList<>();
    }
    public void leggTilTomt(Tomt tomt) {
        if (tomt == null) {
            throw new IllegalArgumentException("Tomt kan ikke være null");
        }
        if (tomter.contains(tomt)) {
            throw new IllegalArgumentException("Tomt finnes allerede i registeret");
        }
        System.out.println("Legger til tomt: " + tomt.toString());
        tomter.add(tomt);
    }

    public void fjernTomt(Tomt tomt) {
        if (tomt == null) {
            throw new IllegalArgumentException("Tomt kan ikke være null");
        }
        if (!tomter.contains(tomt)) {
            throw new IllegalArgumentException("Tomt finnes ikke i registeret");
        }
        System.out.println("Fjerner tomt: " + tomt.toString());
        tomter.remove(tomt);
    }

    public int totaltAntallTomter() {
        return tomter.size();
    }

    public void gjenomsnittAreal() {
        if (tomter.isEmpty()) {
            System.out.println("Ingen tomter i registeret.");
            return;
        }
        double totalAreal = 0;
        for (Tomt tomt : tomter) {
            totalAreal += tomt.getAreal();
        }
        double gjennomsnitt = totalAreal / tomter.size();
        System.out.println("Gjennomsnittlig areal av tomter: " + gjennomsnitt + " kvm");
    }

    public void finnTomt(int kommmuneNr, int gårdsNr, int bruksNr) {
        for (Tomt tomt : tomter) {
            if (tomt.getKommmuneNr() == kommmuneNr && tomt.getGårdsNr() == gårdsNr && tomt.getBruksNr() == bruksNr) {
                System.out.println("Fant tomt: " + tomt.toString());
                return;
            }
        }
        System.out.println("Tomt ikke funnet i registeret.");
    }

    public void finnTomtGårdsNr(int gårdsNr) {
        boolean funnet = false;
        for (Tomt tomt : tomter) {
            if (tomt.getGårdsNr() == gårdsNr) {
                System.out.println("Fant tomt: " + tomt.toString());
                funnet = true;
            }
        }
        if (!funnet) {
            System.out.println("Ingen tomter funnet med gårdsNr: " + gårdsNr);
        }
    }

    public void getAlleTomter() {
        for (Tomt tomt : tomter) {
            System.out.println(tomt.toString());
        }
    }
}
