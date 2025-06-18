import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String s) {
        int num = Integer.parseInt(s);
        System.out.println(num);
    }

    public static void handleException(String s) {
        try {
            int num = Integer.parseInt(s);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        generateException(text);
        handleException(text);
    }
}
