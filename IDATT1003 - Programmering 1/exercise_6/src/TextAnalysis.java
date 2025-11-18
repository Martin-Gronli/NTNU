import java.util.*;

public class TextAnalysis {
    private static int[] quantityChars;
    private final static String[] letters = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};

    public TextAnalysis(String input) {
        quantityChars = new int[30];
        for (int a = 0; a < 30; a++) {
            quantityChars[a] = 0;
        }
        input = input.toLowerCase();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char indexChar = input.charAt(i);
            String letter = Character.toString((char)indexChar);
            int index = Arrays.asList(letters).indexOf(letter);
            if (index == -1) {
                index = 29;
            }
            quantityChars[index] += 1;
        }
    }

    public int getQuantityDifferent() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            if (quantityChars[i] > 0) {
            sum++;
            }
        }
        return sum;
    }

    public int getQuantityLetters() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            sum = quantityChars[i] + sum;
        }
        return sum;
    }

    public double getPercentage() {
        int quantityLetters = getQuantityLetters();
        int quantityDifferent = quantityChars[29];
        double total = quantityLetters + quantityDifferent;
        double percentage = (quantityDifferent / total) * 100;
        return percentage;
    }

    public static int getSpecificLetter(String letter) {
        int index = Arrays.asList(letters).indexOf(letter);
        int sum = 0;
        if (index > -1) {
            sum = quantityChars[index];
        }
        return sum;
    }

    public String getMostOccurences() {
        int highest = -1;
        String highestLetter = "";
        for (int i = 0; i < 29; i++) {
            if (quantityChars[i] > highest) {
                highest = quantityChars[i];
                highestLetter = letters[i];
            } else if (quantityChars[i] == highest) {
                highestLetter = highestLetter + ", " + letters[i];
            }
        }
        return "The letter(s) with most occurences er \"" + highestLetter + "\" ("+ highest +" times)";
    }
}