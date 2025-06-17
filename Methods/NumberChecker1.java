public class NumberChecker1 {
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum == num;
    }
    
    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum > num;
    }
    
    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum < num;
    }
    
    public static boolean isStrong(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == num;
    }
    
    private static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}