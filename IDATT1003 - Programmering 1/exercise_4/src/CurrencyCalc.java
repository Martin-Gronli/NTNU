import javax.swing.*;

class Currency {
    private final String code;
    private final double rate; // how many NOK for 1 unit of given currency

    public Currency(String code, double rate) {
        this.code = code;
        this.rate = rate;
    }
    
    public String getCode() {
        return code;
    }

    public double getRate(double amount) {
        return amount / rate;
    }

}

public class CurrencyCalc {
    public static void main(String[] args) {
        Currency usd = new Currency("USD", 11.0);
        Currency eur = new Currency("EUR", 12.0);
        Currency gbp = new Currency("GBP", 13.4);

        Currency[] currencies = {usd, eur, gbp};
        String[] options = {"USD", "EUR", "GBP", "Quit"};

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose a currency:",
                "Currency Selector",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
                
            );

            if (choice == -1 || choice == 3) {
                break;
            }

            Currency selected = currencies[choice];

            String input = JOptionPane.showInputDialog(
                null,
                "Enter an amount in NOK:",
                "Input amount",
                JOptionPane.PLAIN_MESSAGE
            );

            if (input != null && !input.isBlank()) {
                try {
                    double amount = Double.parseDouble(input);
                    double converted = selected.getRate(amount);                    

                    JOptionPane.showMessageDialog(
                        null,
                        amount + " NOK = " + String.format("%.2f", converted) + " " + selected.getCode()
                    );
                } catch (NumberFormatException e) { 
                    JOptionPane.showMessageDialog(
                        null,
                        "Invalid number"
                        );
                }
            }
        }
    }
}