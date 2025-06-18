import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String s, int start, int end) {
        String sub = s.substring(start, end);
        System.out.println(sub);
    }

    public static void handleException(String s, int start, int end) {
        try {
            String sub = s.substring(start, end);
            System.out.println(sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        generateException(text, end, start);
        handleException(text, end, start);
    }
}
