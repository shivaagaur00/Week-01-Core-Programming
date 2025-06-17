import java.util.Scanner;

public class NumberChecker {
    public static int checkNumber(int number) {
        if (number < 0) return -1;
        return number > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Result: " + checkNumber(num));
    }
}