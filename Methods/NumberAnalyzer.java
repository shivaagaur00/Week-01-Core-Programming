import java.util.Scanner;

public class NumberAnalyzer {
    public static boolean isPositive(int num) {
        return num > 0;
    }
    
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public static int compare(int a, int b) {
        return a > b ? 1 : (a == b ? 0 : -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            nums[i] = sc.nextInt();
            
            if (isPositive(nums[i])) {
                System.out.println(nums[i] + " is positive and " + (isEven(nums[i]) ? "even" : "odd"));
            } else {
                System.out.println(nums[i] + " is negative");
            }
        }
        
        int comparison = compare(nums[0], nums[4]);
        System.out.println("First vs Last: " + 
            (comparison == 1 ? "First > Last" : (comparison == 0 ? "Equal" : "First < Last")));
    }
}