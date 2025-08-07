public class MultipleCatchBlocks {
    public static void main(String[] args) {
        int[] array = null; // change to {1, 2, 3} to test valid
        int index = 2;

        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}