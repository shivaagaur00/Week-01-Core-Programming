import java.util.Scanner;

public class CollinearityChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];

        System.out.println("Enter coordinates of 3 points:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Point " + (i + 1) + " (x y): ");
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        if (isCollinearSlope(x, y))
            System.out.println("Points are collinear (using slope method)");
        else
            System.out.println("Points are not collinear (using slope method)");

        if (isCollinearArea(x, y))
            System.out.println("Points are collinear (using area method)");
        else
            System.out.println("Points are not collinear (using area method)");
    }

    static boolean isCollinearSlope(int[] x, int[] y) {
        return (y[1] - y[0]) * (x[2] - x[1]) == (y[2] - y[1]) * (x[1] - x[0]);
    }

    static boolean isCollinearArea(int[] x, int[] y) {
        return (x[0]*(y[1] - y[2]) + x[1]*(y[2] - y[0]) + x[2]*(y[0] - y[1])) == 0;
    }
}
