import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = 2, c = 2;
        int[][] A = generateMatrix(sc, r, c, "A");
        int[][] B = generateMatrix(sc, r, c, "B");

        int[][] sum = addMatrices(A, B);
        int[][] diff = subtractMatrices(A, B);
        int[][] prod = multiplyMatrices(A, B);

        System.out.println("Addition:");
        displayMatrix(sum);
        System.out.println("Subtraction:");
        displayMatrix(diff);
        System.out.println("Multiplication:");
        displayMatrix(prod);
    }

    static int[][] generateMatrix(Scanner sc, int r, int c, String name) {
        int[][] matrix = new int[r][c];
        System.out.println("Enter elements for Matrix " + name + ":");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();
        return matrix;
    }

    static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
