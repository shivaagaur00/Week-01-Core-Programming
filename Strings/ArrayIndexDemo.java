import java.util.Scanner;

public class ArrayIndexDemo {
    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.next();
        }
        generateException(arr);
        handleException(arr);
    }
}
