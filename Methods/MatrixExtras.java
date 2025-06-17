public class MatrixExtras {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("Transpose:");
        displayMatrix(transpose(matrix));

        System.out.println("Determinant (2x2): " + determinant2x2(matrix));

        int[][] m3 = {{1, 0, 5}, {2, 1, 6}, {3, 4, 0}};
        System.out.println("Determinant (3x3): " + determinant3x3(m3));
    }

    static int[][] transpose(int[][] mat) {
        int[][] t = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                t[j][i] = mat[i][j];
        return t;
    }

    static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }

    static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
