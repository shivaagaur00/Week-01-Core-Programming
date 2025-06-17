import java.util.Scanner;

public class CustomMultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] results = new int[4];
        
        for (int i = 6, j = 0; i <= 9; i++, j++) {
            results[j] = number * i;
            System.out.println(number + " * " + i + " = " + results[j]);
        }
    }
}