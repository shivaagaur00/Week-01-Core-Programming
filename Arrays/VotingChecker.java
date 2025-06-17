import java.util.Scanner;

public class VotingChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 10; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age");
            } else if (ages[i] >= 18) {
                System.out.println("Student " + (i+1) + " with age " + ages[i] + " can vote");
            } else {
                System.out.println("Student " + (i+1) + " with age " + ages[i] + " cannot vote");
            }
        }
    }
}