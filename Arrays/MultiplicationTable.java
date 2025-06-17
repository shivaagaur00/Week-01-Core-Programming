import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for multiplication table: ");
        int baseNumber = input.nextInt();
        final int TABLE_SIZE = 10;
        int[] multiplicationResults = new int[TABLE_SIZE];
        
        if (baseNumber < 0) {
            System.err.println("Error: Please enter a non-negative number");
            System.exit(1);
        }
        
        System.out.println("\nMultiplication Table for " + baseNumber + ":");
        for (int multiplier = 1; multiplier <= TABLE_SIZE; multiplier++) {
            multiplicationResults[multiplier - 1] = baseNumber * multiplier;
            System.out.printf("%d × %d = %d\n", baseNumber, multiplier, multiplicationResults[multiplier - 1]);
        }
        
        input.close();
    }
}