import java.util.Scanner;

public class LengthWithoutMethod {
    public static int customLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int custom = customLength(s);
        int builtIn = s.length();
        System.out.println("Custom length: " + custom);
        System.out.println("Built-in length: " + builtIn);
    }
}

