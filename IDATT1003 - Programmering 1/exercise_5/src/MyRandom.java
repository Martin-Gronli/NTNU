import java.util.Random;

public class MyRandom {

    private final Random random;

    public MyRandom() {
        random = new Random();
    }

    public int nextInteger(int lower, int higher) { //interval (lower, higher)
        return lower + random.nextInt(higher - lower);
    }

    public double nextDecimal(double lower, double higher) { //interval >lower, higher>
        return lower + (higher - lower) * random.nextDouble(); 
    }

public static void main(String[] args) {
        MyRandom mr = new MyRandom();

        System.out.println("Test of integers in interval [10, 50):");
        for (int i = 0; i < 10; i++) {
            int num = mr.nextInteger(10, 50);
            System.out.println(num);
        }

        System.out.println("\nTest of decimals i interval [0.0, 5.0):");
        for (int i = 0; i < 10; i++) {
            double num = mr.nextDecimal(0.0, 5.0);
            //System.out.println(num);
            System.out.printf("%.3f\n",num);
        }
    }
}