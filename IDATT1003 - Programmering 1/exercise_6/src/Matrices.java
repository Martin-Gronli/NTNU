import Jama.Matrix;
import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Hardcoded matrix
        double[][] hardcodedArray = {
            {2, 4, 6},
            {8, 10, 12}
        };
        Matrix A = new Matrix(hardcodedArray);

        // Input another matrix from user
        System.out.print("Enter number of rows for matrix B: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns for matrix B: ");
        int cols = sc.nextInt();

        double[][] inputArray = new double[rows][cols];

        System.out.println("Enter elements of matrix B row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                inputArray[i][j] = sc.nextDouble();
            }
        }

        Matrix B = new Matrix(inputArray);

        System.out.println("Matrix A:");
        A.print(5, 2);
        System.out.println("Matrix B:");
        B.print(5, 2);

        // Try addition
        try {
            Matrix sum = A.plus(B);
            System.out.println("A + B:");
            sum.print(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Addition not possible: Matrices must have the same dimensions.\n");
        }

        // Try multiplication
        try {
            Matrix product = A.times(B);
            System.out.println("A * B:");
            product.print(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Multiplication not possible: A's columns must match B's rows.\n");
        }

        // Transpose
        System.out.println("Transpose of A:");
        A.transpose().print(5, 2);

        System.out.println("Transpose of B:");
        B.transpose().print(5, 2);

        sc.close();
    }
}
