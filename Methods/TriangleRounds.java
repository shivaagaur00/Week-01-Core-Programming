import java.util.Scanner;

public class TriangleRounds {
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = sc.nextDouble();
        System.out.println("Rounds needed: " + calculateRounds(side1, side2, side3));
    }
}