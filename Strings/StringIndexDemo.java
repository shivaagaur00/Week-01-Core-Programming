import java.util.Scanner;

public class StringIndexDemo {
    public static void generateException(String text) {
        char ch = text.charAt(text.length());
        System.out.println(ch);
    }

    public static void handleException(String text) {
        try {
            char ch = text.charAt(text.length());
            System.out.println(ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        generateException(text);
        handleException(text);
    }
}
