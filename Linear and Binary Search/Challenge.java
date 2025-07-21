import java.util.Arrays;
import java.util.Scanner;
public class Challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 4, -1, 1};
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) present[num] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                System.out.println("First missing: " + i);
                break;
            }
        }
        Arrays.sort(arr);
        int target = sc.nextInt();
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                System.out.println("Index: " + mid);
                return;
            } else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        System.out.println("Index: -1");
    }
}
