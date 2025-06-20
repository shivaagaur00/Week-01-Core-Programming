import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result: " + add(a, b)); break;
            case '-': System.out.println("Result: " + subtract(a, b)); break;
            case '*': System.out.println("Result: " + multiply(a, b)); break;
            case '/': System.out.println("Result: " + divide(a, b)); break;
            default: System.out.println("Invalid Operation");
        }
    }

    static double add(double a, double b) { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero error");
            return 0;
        }
        return a / b;
    }
}
