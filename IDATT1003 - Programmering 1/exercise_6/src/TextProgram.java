import java.util.*;

public class TextProgram {
    public static void main(String[] args) {
        boolean toggle = true;
        while (toggle) {
            start();
        }
    }
   
    public static void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input text for analyzing: ");
        String input = in.nextLine();
        TextAnalysis textanalysis = new TextAnalysis(input);
        analyse(textanalysis);
        in.close();
    }


    public static void analyse(TextAnalysis textanalysis) {
        System.out.println("Number of different letters: " + textanalysis.getQuantityDifferent());
        System.out.println("Number of letters: " + textanalysis.getQuantityLetters());
        System.out.println("Percentage which is not letters: " + textanalysis.getPercentage() + "%");
        System.out.println(textanalysis.getMostOccurences());
    }
    
}
