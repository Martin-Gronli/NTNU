public class minced_meat {
    public static void main(String[] args) {
        double meat_a_gram = 450;
        double meat_a_price = 35.90;
        double meat_b_gram = 500;
        double meat_b_price = 39.50;

        double meat_a = meat_a_price / meat_a_gram;
        double meat_b = meat_b_price / meat_b_gram;

        System.out.printf("Price per gram(rounded) of meat A: %.3f\n", meat_a);
        System.out.printf("Price per gram(rounded) of meat B: %.3f\n", meat_b);
        if (meat_a < meat_b) {
            System.out.println("Meat A is cheaper per gram.");
        } else if (meat_b < meat_a) {
            System.out.println("Meat B is cheaper per gram.");
        } else {
            System.out.println("Both meats have the same price per gram.");
        }
    }

}
