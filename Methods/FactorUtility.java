import java.util.*;

public class FactorUtility {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int factor : factors) {
            if (factor > max) max = factor;
        }
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) sum += factor;
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) product *= factor;
        return product;
    }

    public static double cubeProductOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static void main(String[] args) {
        int number = 12;
        System.out.println("Number: " + number);
        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
        System.out.println("Cube Product of Factors: " + cubeProductOfFactors(factors));
    }
}
