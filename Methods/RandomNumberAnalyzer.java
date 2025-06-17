public class RandomNumberAnalyzer {
    public static int[] generate4DigitRandomArray(int size) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) nums[i] = (int)(Math.random() * 9000) + 1000;
        return nums;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new double[]{(double)sum/numbers.length, min, max};
    }

    public static void main(String[] args) {
        int[] nums = generate4DigitRandomArray(5);
        System.out.print("Numbers: ");
        for (int num : nums) System.out.print(num + " ");
        
        double[] results = findAverageMinMax(nums);
        System.out.println("\nAverage: " + results[0]);
        System.out.println("Min: " + results[1]);
        System.out.println("Max: " + results[2]);
    }
}