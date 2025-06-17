import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        int[][] marks = new int[n][3];
        double[] avg = new double[n];
        char[] grade = new char[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i+1));
            
            System.out.print("Physics marks: ");
            marks[i][0] = sc.nextInt();
            
            System.out.print("Chemistry marks: ");
            marks[i][1] = sc.nextInt();
            
            System.out.print("Maths marks: ");
            marks[i][2] = sc.nextInt();
            
            avg[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            
            if (avg[i] >= 80) grade[i] = 'A';
            else if (avg[i] >= 70) grade[i] = 'B';
            else if (avg[i] >= 60) grade[i] = 'C';
            else if (avg[i] >= 50) grade[i] = 'D';
            else if (avg[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }
        
        System.out.println("\nResults:");
        System.out.println("Student Physics Chemistry Maths Avg Grade");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + " " + marks[i][0] + " " + marks[i][1] + " " + 
                             marks[i][2] + " " + avg[i] + " " + grade[i]);
        }
    }
}