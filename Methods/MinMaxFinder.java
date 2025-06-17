import java.util.Scanner;

public class MinMaxFinder {
    public static int[] findMinMax(int a, int b, int c) {
        return new int[]{Math.min(Math.min(a, b), c), Math.max(Math.max(a, b), c)};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int[] result = findMinMax(num1, num2, num3);
        System.out.println("Smallest: " + result[0] + ", Largest: " + result[1]);
    }
}