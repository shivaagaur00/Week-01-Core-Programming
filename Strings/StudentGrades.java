import java.util.*;

public class StudentGrades {
    public static int[][] generateMarks(int n) {
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = (int) (Math.random() * 51) + 50;
        return arr;
    }

    public static double[][] calculateScores(int[][] arr) {
        double[][] scores = new double[arr.length][3];
        for (int i = 0; i < arr.length; i++) {
            double total = arr[i][0] + arr[i][1] + arr[i][2];
            scores[i][0] = total;
            scores[i][1] = total / 3.0;
            scores[i][2] = Math.round((total / 300.0) * 10000.0) / 100.0;
        }
        return scores;
    }

    public static String[] getGrades(double[][] scores) {
        String[] grades = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            double p = scores[i][2];
            if (p >= 90) grades[i] = "A";
            else if (p >= 80) grades[i] = "B";
            else if (p >= 70) grades[i] = "C";
            else if (p >= 60) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void display(int[][] marks, double[][] scores, String[] grades) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t");
            System.out.print((int) scores[i][0] + "\t" + String.format("%.2f", scores[i][1]) + "\t");
            System.out.print(scores[i][2] + "\t" + grades[i] + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] marks = generateMarks(n);
        double[][] scores = calculateScores(marks);
        String[] grades = getGrades(scores);
        display(marks, scores, grades);
    }
}
