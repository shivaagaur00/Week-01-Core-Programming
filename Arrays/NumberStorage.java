import java.util.Scanner;

public class NumberStorage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX_SIZE = 10;
        double[] storedNumbers = new double[MAX_SIZE];
        double sum = 0.0;
        int currentIndex = 0;
        
        System.out.println("Enter numbers (0 or negative to stop):");
        
        while (true) {
            System.out.print("Enter number #" + (currentIndex + 1) + ": ");
            double number = input.nextDouble();
            
            if (number <= 0) {
                break;
            }
            if (currentIndex >= MAX_SIZE) {
                break;
            }
            
            storedNumbers[currentIndex++] = number;
        }
        
        System.out.println("\nStored Numbers:");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println("Position " + i + ": " + storedNumbers[i]);
            sum += storedNumbers[i];
        }
        
        System.out.println("\nTotal sum: " + sum);
        input.close();
    }
}