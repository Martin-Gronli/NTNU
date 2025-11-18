public class Tomt {
    private int kommmuneNr;
    private String KommuneNavn;
    private int gårdsNr;
    private int bruksNr;
    private String navn;
    private double areal;
    private String eier;

    public Tomt(int kommmuneNr, String kommuneNavn, int gårdsNr, int bruksNr, String navn, double areal, String eier) {
        if (kommmuneNr <= 101 || kommmuneNr >= 5054) {
            throw new IllegalArgumentException("Ugyldig kommunenummer, må være mellom 101 og 5054");
        }
        if (kommuneNavn == null || navn == null || eier == null) {
            throw new IllegalArgumentException("Navn kan ikke være null");
        }
        if (areal <= 0 || gårdsNr < 1 || bruksNr < 0) {
            throw new IllegalArgumentException("Verdier må være positive");
        }
        this.kommmuneNr = kommmuneNr;
        this.KommuneNavn = kommuneNavn;
        this.gårdsNr = gårdsNr;
        this.bruksNr = bruksNr;
        this.navn = navn;
        this.areal = areal;
        this.eier = eier;
    }

    public Tomt(int kommmuneNr, String kommuneNavn, int gårdsNr, int bruksNr, double areal, String eier) {
        if (kommmuneNr <= 101 || kommmuneNr >= 5054) {
            throw new IllegalArgumentException("Ugyldig kommunenummer, må være mellom 101 og 5054");
        }
        if (kommuneNavn == null || eier == null) {
            throw new IllegalArgumentException("Verdier kan ikke være null");
        }
        if (areal <= 0 || gårdsNr < 1 || bruksNr < 0) {
            throw new IllegalArgumentException("Verdier må være positive");
        }
        this.kommmuneNr = kommmuneNr;
        this.KommuneNavn = kommuneNavn;
        this.gårdsNr = gårdsNr;
        this.bruksNr = bruksNr;
        this.areal = areal;
        this.eier = eier;
    }

    public int getKommmuneNr() {
        return this.kommmuneNr;
    }

    public String getKommuneNavn() {
        return this.KommuneNavn;
    }

    public int getGårdsNr() {
        return this.gårdsNr;
    }

    public int getBruksNr() {
        return this.bruksNr;
    }

    public String getNavn() {
        return this.navn;
    }

    public double getAreal() {
        return this.areal;
    }

    public String getEier() {
        return this.eier;
    }

    public String getID() {
        return this.kommmuneNr + "-" + this.gårdsNr + "/" + this.bruksNr;
    }

    public void setEier(String nyEier) {
        this.eier = nyEier;
    }

    @Override
    public String toString() {
        if (this.getNavn() != null) {
            return "Tomt: " + this.getID() + ", Navn: " + this.getNavn() + ", Areal: " + this.getAreal() + " kvm, Eier: " + this.getEier();
        } else {
            return "Tomt: " + this.getID() + ", Areal: " + this.getAreal() + " kvm, Eier: " + this.getEier();
        }
    }
}