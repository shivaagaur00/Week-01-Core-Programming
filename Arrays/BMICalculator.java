import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        
        double[][] data = new double[n][3];
        String[] status = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i+1));
            
            System.out.print("Height (m): ");
            double h = sc.nextDouble();
            while (h <= 0) {
                System.out.print("Invalid! Enter height again: ");
                h = sc.nextDouble();
            }
            
            System.out.print("Weight (kg): ");
            double w = sc.nextDouble();
            while (w <= 0) {
                System.out.print("Invalid! Enter weight again: ");
                w = sc.nextDouble();
            }
            
            double bmi = w / (h * h);
            data[i][0] = h;
            data[i][1] = w;
            data[i][2] = bmi;
            
            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        
        System.out.println("\nResults:");
        System.out.println("Height Weight BMI Status");
        for (int i = 0; i < n; i++) {
            System.out.println(data[i][0] + " " + data[i][1] + " " + 
                             data[i][2] + " " + status[i]);
        }
    }
}