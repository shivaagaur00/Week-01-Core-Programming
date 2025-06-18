import java.util.Scanner;

public class LowercaseCompare {
    public static String toLower(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') result += (char)(ch + 32);
            else result += ch;
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
        String text = sc.nextLine();
        String builtIn = text.toLowerCase();
        String manual = toLower(text);
        boolean result = compare(builtIn, manual);
        System.out.println("Match: " + result);
    }
}
