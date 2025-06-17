import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] distributeChocolates(int chocolates, int children) {
        return new int[]{chocolates / children, chocolates % children};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter chocolates: ");
        int choco = sc.nextInt();
        System.out.print("Enter children: ");
        int children = sc.nextInt();
        int[] result = distributeChocolates(choco, children);
        System.out.println("Each gets: " + result[0] + ", Remaining: " + result[1]);
    }
}