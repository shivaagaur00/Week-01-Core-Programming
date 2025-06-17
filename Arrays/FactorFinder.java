import java.util.Scanner;
import java.util.Arrays;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.err.println("Error: Input must be a positive integer");
            System.exit(1);
        }
        int initialCapacity = 10;
        int[] factors = new int[initialCapacity];
        int factorCount = 0;
        for (int potentialFactor = 1; potentialFactor <= number; potentialFactor++) {
            if (number % potentialFactor == 0) {
                if (factorCount >= factors.length) {
                    factors = Arrays.copyOf(factors, factors.length * 2);
                }
                factors[factorCount++] = potentialFactor;
            }
        }
        factors = Arrays.copyOf(factors, factorCount);
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        
        input.close();
    }
}