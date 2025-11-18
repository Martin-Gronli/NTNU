public final class Person {
    private final String firstName;
    private final String lastName;
    private final int birthYear;

    public Person(String navn, String lastName, int birthYear) {
        this.firstName = navn;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (født " + birthYear + ")";
    }
}
