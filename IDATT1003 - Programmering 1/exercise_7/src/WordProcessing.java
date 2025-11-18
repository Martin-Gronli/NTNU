import java.nio.charset.StandardCharsets;
import java.util.Scanner;
//teststring martin Martin martin - Deler av Nordlandsbanen og Trønderbanen kommer snart i, gang igjen, skriver SJ Norge i en pressemelding.

public class WordProcessing {
    private final String text;

    public WordProcessing(String text) {
        this.text = text;

    }

    public String getText() {
        return text;

    }

    public String getCapitalLetters() {
        String capitals = text.toUpperCase();
        return capitals;
    }

    public String replaceWord() {
        String replaced = text.replace("martin", "vegard");
        return replaced;

    }

    public int getQuantityWords() {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s");
        return words.length;

    }

    public double getAverageLength() {
        String[] words = text.trim().split("[\\s,;.]+");
        int totalLength = 0;
        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                totalLength += word.length();
                wordCount++;
            }
        }

        if (wordCount == 0)
            return 0.0;

        return (double) totalLength / wordCount;

    }

    public double getAverageWordsPerPeriod() {
        String[] periods = text.split("[.:!?]");
        int totalWords = 0;
        int periodCount = 0;

        for (String period : periods) {
            period = period.trim();
            if (!period.isEmpty()) {
                String[] words = period.split("\\s+");
                totalWords += words.length;
                periodCount++;

            }
        }

        if (periodCount == 0) {
            return 0.0;

        }
        
        return (double) totalWords / periodCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Input text for processing");
        String input = in.nextLine();
        WordProcessing text = new WordProcessing(input);

        try {
            int quantity = text.getQuantityWords();
            System.out.println("Quantity of words: " + quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("Quantity not possible to show.");
        }

        try {
            Double averageLength = text.getAverageLength();
            System.out.println("Average word length: " + averageLength);
        } catch (IllegalArgumentException e) {
            System.out.println("Average word length not possible to show");
        }

        try {
            Double averageWordsPerPeriod = text.getAverageWordsPerPeriod();
            System.out.println("Average words per period: " + averageWordsPerPeriod);
        } catch (IllegalArgumentException e) {
            System.out.println("Average words per period not possible to show");
        }

        try {
            String replaced = text.replaceWord();
            System.out.println("Whole text replaced: " + replaced);
        } catch (IllegalArgumentException e) {
            System.out.println("Replaced text not possible to show");
        }

        try {
            String wholeText = text.getText();
            System.out.println("Whole text: " + wholeText);
        } catch (IllegalArgumentException e) {
            System.out.println("Whole text not possible to show");
        }

        try {
            String capitals = text.getCapitalLetters();
            System.out.println("Whole text in capitals " + capitals);            
        } catch (IllegalArgumentException e) {
            System.out.println("Whole text in capitals not possible to show");
        }
        
        in.close();
    }



}
