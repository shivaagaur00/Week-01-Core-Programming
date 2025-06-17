import java.util.Scanner;

public class RecursiveSum {
    public static int recursiveSum(int n) {
        return n == 1 ? 1 : n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        int recSum = recursiveSum(n);
        int formSum = formulaSum(n);
        
        System.out.println("Recursive sum: " + recSum);
        System.out.println("Formula sum: " + formSum);
        System.out.println("Match: " + (recSum == formSum));
    }
}