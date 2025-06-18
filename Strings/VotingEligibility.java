import java.util.*;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * 60 + 10);
        return arr;
    }

    public static String[][] checkVoting(int[] ages) {
        String[][] arr = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            arr[i][0] = String.valueOf(ages[i]);
            arr[i][1] = ages[i] < 0 ? "false" : ages[i] >= 18 ? "true" : "false";
        }
        return arr;
    }

    public static void display(String[][] arr) {
        System.out.println("Age\tCan Vote");
        for (String[] row : arr)
            System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[] ages = generateAges(n);
        String[][] result = checkVoting(ages);
        display(result);
    }
}
