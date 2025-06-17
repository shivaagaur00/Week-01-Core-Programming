public class NumberChecker2 {
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }
    
    public static int[] getDigits(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        for (int i = count-1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
    
    public static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        for (int i = 0; i < digits.length/2; i++) 
            if (digits[i] != digits[digits.length-1-i]) return false;
        return true;
    }
    
    public static boolean isDuck(int num) {
        int[] digits = getDigits(num);
        for (int i = 1; i < digits.length; i++) 
            if (digits[i] == 0) return true;
        return false;
    }
}