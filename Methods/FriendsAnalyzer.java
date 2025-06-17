import java.util.Scanner;

public class FriendsAnalyzer {
    public static int findYoungest(int[] ages) {
        return Math.min(Math.min(ages[0], ages[1]), ages[2]);
    }
    
    public static double findTallest(double[] heights) {
        return Math.max(Math.max(heights[0], heights[1]), heights[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height for " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        
        System.out.println("Youngest age: " + findYoungest(ages));
        System.out.println("Tallest height: " + findTallest(heights));
    }
}
