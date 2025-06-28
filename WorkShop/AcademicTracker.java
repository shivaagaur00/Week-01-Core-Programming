import java.util.*;
class CustomException extends Exception {
    CustomException(String msg) {
        super(msg);
    }
}
class StudentRecord {
    String studentName;
    int[] subjectScores;
    int totalPoints;
    double averageScore;
    String finalGrade;
    StudentRecord(String name, int[] scores) throws CustomException {
        studentName = name;
        subjectScores = new int[scores.length];
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] < 0 || scores[i] > 100) {
                throw new CustomException("Scores must be 0-100");
            }
            subjectScores[i] = scores[i];
        }
        calculateGrades();
    }
    void calculateGrades() {
        totalPoints = 0;
        for(int score : subjectScores) {
            totalPoints += score;
        }
        averageScore = (double)totalPoints / subjectScores.length;
        if(averageScore >= 90) finalGrade = "A+";
        else if(averageScore >= 80) finalGrade = "A";
        else if(averageScore >= 70) finalGrade = "B";
        else if(averageScore >= 60) finalGrade = "C";
        else if(averageScore >= 50) finalGrade = "D";
        else finalGrade = "F";
    }

    void showResults() {
        System.out.println("Name:"+ studentName);
        System.out.println("Scores:"+ Arrays.toString(subjectScores));
        System.out.println("Total: " + totalPoints);
        System.out.printf("Average: ", averageScore);
        System.out.println("Grade: " + finalGrade);
    }
}
public class AcademicTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentRecord> students = new ArrayList<>();

        System.out.print("No. Of Students? ");
        int studentCount = sc.nextInt();

        for(int i=0;i<studentCount; i++) {
            String name = sc.nextLine();
            System.out.print("No of subjects: ");
            int subjectCount = sc.nextInt();
            int[] marks = new int[subjectCount];
            System.out.println("Enter marks:");
            for(int j = 0; j < subjectCount; j++) {
                marks[j] = sc.nextInt();
            }
            try {
                students.add(new StudentRecord(name, marks));
            } catch(CustomException e) {
                System.out.println("Invalid : " + e.getMessage());
                i--;
            }
        }
        System.out.println("RESULTS");
        for(StudentRecord sr : students) {
            sr.showResults();
        }
    }
}