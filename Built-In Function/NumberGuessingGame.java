import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: high/low/correct)");
            String feedback = sc.next();
            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("correct")) {
                System.out.println("Yay! Guessed your number.");
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }
}
