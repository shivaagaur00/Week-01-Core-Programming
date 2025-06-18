import java.util.Scanner;

public class SubstringCompare {
    public static String manualSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String builtIn = text.substring(start, end);
        String manual = manualSubstring(text, start, end);
        boolean result = compare(builtIn, manual);
        System.out.println("Match: " + result);
    }
}
