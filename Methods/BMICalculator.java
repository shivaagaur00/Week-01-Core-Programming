import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] statuses = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);
        determineBMIStatus(data, statuses);

        System.out.println("Weight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.1f\t%.1f\t%.2f\t%s\n", data[i][0], data[i][1], data[i][2], statuses[i]);
        }
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightInM = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInM * heightInM);
        }
    }

    public static void determineBMIStatus(double[][] data, String[] statuses) {
        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4)
                statuses[i] = "Underweight";
            else if (bmi <= 24.9)
                statuses[i] = "Normal";
            else if (bmi <= 39.9)
                statuses[i] = "Overweight";
            else
                statuses[i] = "Obese";
        }
    }
}
