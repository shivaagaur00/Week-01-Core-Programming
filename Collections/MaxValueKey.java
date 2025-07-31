import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(maxKey);
    }
}