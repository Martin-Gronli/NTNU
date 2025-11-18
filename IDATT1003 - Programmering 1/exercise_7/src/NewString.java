import java.nio.charset.StandardCharsets;
import java.util.*;
//teststring Jeg har tillit til at bystyret og eventuelt kontrollutvalg ettergår det som de mener er nødvendig, skriver hun i en SMS til Adresseavisen

public final class NewString {
    private final String text;

    public NewString(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String shortenText() {
        String firstLetters = "";
        for(String s : this.text.split(" "))
        {
            firstLetters += s.charAt(0);
        }
        return firstLetters;
    }

    public String removeE() {
        return this.text.replaceAll("[eE]", "");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Input text for processing: ");
        String input = in.nextLine();
        NewString text = new NewString(input);

        try {
            String shortened = text.shortenText();
            System.out.println("Shortened text: " + shortened);
        } catch (IllegalArgumentException e) {
            System.out.println("Shortening not possible.");
        }

        try {
            String removed = text.removeE();
            System.out.println("Text with all e's removed: " + removed);
        } catch (IllegalArgumentException e) {
            System.out.println("Removing e's not possible.");
        }
        
        in.close();
    }

}
