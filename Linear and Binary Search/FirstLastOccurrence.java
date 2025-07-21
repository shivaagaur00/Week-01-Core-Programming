import java.util.Arrays;
public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 8};
        int target = 4;
        int first = -1, last = -1;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) first = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) last = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        System.out.println(Arrays.toString(new int[]{first, last}));
    }
}
