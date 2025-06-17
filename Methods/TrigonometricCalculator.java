import java.util.Scanner;

public class TrigonometricCalculator {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];
        results[0] = Math.sin(radians);
        results[1] = Math.cos(radians);
        results[2] = Math.tan(radians);
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        
        double[] trigResults = calculateTrigonometricFunctions(angle);
        System.out.println("Sin: " + trigResults[0]);
        System.out.println("Cos: " + trigResults[1]);
        System.out.println("Tan: " + trigResults[2]);
    }
}