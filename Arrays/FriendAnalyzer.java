import java.util.Scanner;

public class FriendAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        System.out.println("Enter ages and heights for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print(names[i] + "'s age: ");
            ages[i] = sc.nextInt();
            System.out.print(names[i] + "'s height: ");
            heights[i] = sc.nextDouble();
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("Youngest friend: " + names[youngestIndex]);
        System.out.println("Tallest friend: " + names[tallestIndex]);
    }
}