import java.util.*;
public class DataStructureComparison {
    public static void main(String[] args) {
        int n = 1000000;
        int[] arr = new Random().ints(n, 0, n).toArray();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : arr) {
            hashSet.add(num);
            treeSet.add(num);
        }
        int target = arr[n / 2];

        long start = System.nanoTime();
        for (int val : arr) {
            if (val == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        boolean found = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1e6 + " ms, Found: " + found);

        start = System.nanoTime();
        found = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1e6 + " ms, Found: " + found);
    }
}
