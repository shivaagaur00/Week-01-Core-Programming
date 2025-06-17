import java.util.Scanner;

public class QuotientRemainder {
    public static int[] calculate(int num, int divisor) {
        return new int[]{num / divisor, num % divisor};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter divisor: ");
        int div = sc.nextInt();
        int[] result = calculate(num, div);
        System.out.println("Quotient: " + result[0] + ", Remainder: " + result[1]);
    }
}