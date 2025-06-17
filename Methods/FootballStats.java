import java.util.Scanner;

public class FootballStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];
        System.out.println("Enter height of 11 players (150-250 cm):");

        for (int i = 0; i < 11; i++) {
            heights[i] = sc.nextInt();
        }

        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        double mean = findMean(heights);

        System.out.println("Shortest Player Height: " + shortest + " cm");
        System.out.println("Tallest Player Height: " + tallest + " cm");
        System.out.printf("Mean Height: %.2f cm\n", mean);
    }

    static int findShortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int val : arr) if (val < min) min = val;
        return min;
    }

    static int findTallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) if (val > max) max = val;
        return max;
    }

    static double findMean(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return (double) sum / arr.length;
    }
}
