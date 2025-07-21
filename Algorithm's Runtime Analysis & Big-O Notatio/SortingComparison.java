import java.util.*;
public class SortingComparison {
    public static void main(String[] args) {
        int[] data = new Random().ints(10000, 0, 10000).toArray();
        int[] copy1 = Arrays.copyOf(data, data.length);
        int[] copy2 = Arrays.copyOf(data, data.length);

        long start = System.nanoTime();
        bubbleSort(copy1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        Arrays.sort(copy2);
        end = System.nanoTime();
        System.out.println("Built-in Sort Time: " + (end - start) / 1e6 + " ms");
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
