import java.util.*;

public class TrimString {
    public static int[] trimIndices(String s) {
        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') start++;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String substringByCharAt(String s, int start, int end) {
        String res = "";
        for (int i = start; i <= end; i++) res += s.charAt(i);
        return res;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] ind = trimIndices(input);
        String trimmedByCharAt = substringByCharAt(input, ind[0], ind[1]);
        String trimmedByMethod = input.trim();
        boolean isSame = compareStrings(trimmedByCharAt, trimmedByMethod);
        System.out.println("CharAt Trim: '" + trimmedByCharAt + "'");
        System.out.println("Built-in Trim: '" + trimmedByMethod + "'");
        System.out.println("Equal: " + isSame);
    }
}
