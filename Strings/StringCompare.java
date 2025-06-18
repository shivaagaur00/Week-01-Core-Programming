import java.util.Scanner;

public class StringCompare {
    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        boolean manual = compare(a, b);
        boolean builtIn = a.equals(b);
        System.out.println("Match manual: " + manual);
        System.out.println("Match built-in: " + builtIn);
    }
}
