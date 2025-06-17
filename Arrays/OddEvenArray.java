import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int userNumber = input.nextInt();
        if (userNumber <= 0) {
            System.err.println("Error: Input must be a natural number");
            System.exit(1);
        }
        int[] oddNumbers = new int[(userNumber + 1) / 2];
        int[] evenNumbers = new int[userNumber / 2];
        int oddIndex = 0, evenIndex = 0;
        
        for (int currentNumber = 1; currentNumber <= userNumber; currentNumber++) {
            if (currentNumber % 2 == 0) {
                evenNumbers[evenIndex++] = currentNumber;
            } else {
                oddNumbers[oddIndex++] = currentNumber;
            }
        }
        
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        
        input.close();
    }
}