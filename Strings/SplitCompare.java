import java.util.*;

public class SplitCompare {
    public static int getLength(String s) {
        int i = 0;
        try {
            while (true) s.charAt(i++);
        } catch (Exception e) {}
        return i;
    }

    public static String[] customSplit(String s) {
        s += " ";
        int count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == ' ') count++;
        String[] arr = new String[count];
        int start = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[idx++] = s.substring(start, i);
                start = i + 1;
            }
        }
        return arr;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] builtIn = text.split(" ");
        String[] custom = customSplit(text);
        boolean equal = compareArrays(builtIn, custom);
        System.out.println("Match: " + equal);
    }
}
