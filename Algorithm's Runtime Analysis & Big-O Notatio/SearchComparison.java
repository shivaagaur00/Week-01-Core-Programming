import java.util.*;
public class SearchComparison {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        for (int i = 0; i < data.length; i++) data[i] = i;
        int target = 999999;

        long start = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(data);
        int index = Arrays.binarySearch(data, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) + " ns, Found at index: " + index);
    }
}
