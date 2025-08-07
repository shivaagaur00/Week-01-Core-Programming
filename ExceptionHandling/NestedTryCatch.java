public class NestedTryCatch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int index = 1;
        int divisor = 0;

        try {
            try {
                int value = arr[index];
                System.out.println("Value: " + value);
                System.out.println("Result: " + (value / divisor));
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}