import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String input = takeInput();
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }

    static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean isPalindrome(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(rev);
    }

    static void displayResult(String input, boolean result) {
        System.out.println(input + " is " + (result ? "a Palindrome" : "not a Palindrome"));
    }
}
