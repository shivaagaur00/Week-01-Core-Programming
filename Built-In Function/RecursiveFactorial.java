import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        int n = input();
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    static int input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
