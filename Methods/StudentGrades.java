import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        String[] grades = new String[n];
        double[] percentages = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks of student " + (i + 1) + " (Physics Chemistry Math):");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
            }
            percentages[i] = ((marks[i][0] + marks[i][1] + marks[i][2]) / 300.0) * 100;
            grades[i] = assignGrade(percentages[i]);
        }

        System.out.println("Student\tPhysics\tChem\tMath\t%\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%s\n", i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }

    static String assignGrade(double percent) {
        if (percent >= 80) return "A";
        if (percent >= 70) return "B";
        if (percent >= 60) return "C";
        if (percent >= 50) return "D";
        if (percent >= 40) return "E";
        return "R";
    }
}
