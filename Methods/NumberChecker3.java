import java.util.*;

public class NumberChecker3 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static void findTwoLargest(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > first) {
                second = first;
                first = digit;
            } else if (digit > second && digit != first) {
                second = digit;
            }
        }
        System.out.println("Largest: " + first + ", Second Largest: " + second);
    }

    public static void findTwoSmallest(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < first) {
                second = first;
                first = digit;
            } else if (digit < second && digit != first) {
                second = digit;
            }
        }
        System.out.println("Smallest: " + first + ", Second Smallest: " + second);
    }

    public static void main(String[] args) {
        int number = 153;
        System.out.println("Number: " + number);
        int[] digits = getDigitsArray(number);
        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Is Duck Number? " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number? " + isArmstrongNumber(number, digits));
        findTwoLargest(digits);
        findTwoSmallest(digits);
    }
}
