import java.util.Scanner;

public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int limit = input.nextInt();
        
        if (limit <= 0) {
            System.err.println("Error: Input must be a positive integer");
            System.exit(1);
        }
        
        String[] fizzBuzzResults = new String[limit + 1];
        
        for (int currentNumber = 0; currentNumber <= limit; currentNumber++) {
            if (currentNumber % 15 == 0) {
                fizzBuzzResults[currentNumber] = "FizzBuzz";
            } else if (currentNumber % 3 == 0) {
                fizzBuzzResults[currentNumber] = "Fizz";
            } else if (currentNumber % 5 == 0) {
                fizzBuzzResults[currentNumber] = "Buzz";
            } else {
                fizzBuzzResults[currentNumber] = String.valueOf(currentNumber);
            }
        }
        
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i <= limit; i++) {
            System.out.println("Position " + i + " = " + fizzBuzzResults[i]);
        }
        
        input.close();
    }
}