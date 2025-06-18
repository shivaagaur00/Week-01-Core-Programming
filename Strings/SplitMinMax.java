import java.util.*;

public class SplitMinMax {
    public static String[] splitWords(String s) {
        s += " ";
        int count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == ' ') count++;
        String[] words = new String[count];
        int start = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words[idx++] = s.substring(start, i);
                start = i + 1;
            }
        }
        return words;
    }

    public static int getLength(String s) {
        int i = 0;
        try {
            while (true) s.charAt(i++);
        } catch (Exception e) {}
        return i;
    }

    public static String[][] getLengths(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(getLength(words[i]));
        }
        return arr;
    }

    public static int[] findMinMax(String[][] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minIdx = 0, maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < min) {
                min = len;
                minIdx = i;
            }
            if (len > max) {
                max = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = splitWords(s);
        String[][] arr = getLengths(words);
        int[] res = findMinMax(arr);
        System.out.println("Shortest: " + arr[res[0]][0]);
        System.out.println("Longest: " + arr[res[1]][0]);
    }
}
