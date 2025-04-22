import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking matrix size input
        System.out.print("Enter the number of rows and columns for the matrices: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        // Input for first matrix
        System.out.println("Enter values for Matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        // Input for second matrix
        System.out.println("Enter values for Matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        // Performing addition
        System.out.println("Addition of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((matrix1[i][j] + matrix2[i][j]) + " ");
            }
            System.out.println();
        }

        // Performing subtraction
        System.out.println("Subtraction of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((matrix1[i][j] - matrix2[i][j]) + " ");
            }
            System.out.println();
        }

        // Performing multiplication
        System.out.println("Multiplication of matrices:");
        int[][] multiplicationResult = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                multiplicationResult[i][j] = matrix1[i][j] * matrix2[i][j];
                System.out.print(multiplicationResult[i][j] + " ");
            }
            System.out.println();
        }

        // Performing element-wise division (handling division by zero)
        System.out.println("Element-wise Division of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix2[i][j] != 0) {
                    System.out.print((matrix1[i][j] / (double) matrix2[i][j]) + " ");
                } else {
                    System.out.print("Undefined "); // Handling division by zero
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
