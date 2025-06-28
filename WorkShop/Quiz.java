import java.util.*;

class QuizProcess {
    public static int calculateScore(String[] correct, String[] user) {
        if (correct.length != user.length) {
            throw new IllegalArgumentException("Answer length mismatch");
        }
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equals(user[i])) {
                score++;
            }
        }
        return score;
    }

    public static String getGrade(int score, int total) {
        double percent = (score * 100.0) / total;
        if (percent >= 90) return "A";
        if (percent >= 80) return "B";
        if (percent >= 70) return "C";
        if (percent >= 60) return "D";
        return "F";
    }
}

public class Quiz {
    List<Integer> scores;
    Quiz(){
        scores= new ArrayList<>();
    }
    public static void main(String[] args) {
        Quiz q=new Quiz();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of questions : ");
        int n= sc.nextInt();
        sc.nextLine();
        String[] correctAnswers = new String[n];
        System.out.println("Enter correct answers:");
        for (int i = 0; i < n; i++) {
            correctAnswers[i] = sc.nextLine();
        }
        System.out.print("Enter number of users: ");
        int numUsers = sc.nextInt();
        sc.nextLine();
        List<Integer> scores = new ArrayList<>();
        for (int u = 0; u < numUsers; u++) {
            System.out.println("Enter answers of user ");
            String[] userAnswers = new String[n];
            for (int i = 0; i < n; i++) {
                userAnswers[i] = sc.nextLine().trim();
            }
            try {
                int score = QuizProcess.calculateScore(correctAnswers, userAnswers);
                scores.add(score);
                String grade = QuizProcess.getGrade(score, n);
                System.out.println("UserScore: " + score + ",Grade:"+grade);
            } catch (IllegalArgumentException e) {
                System.out.println("User "+ e.getMessage());
            }
        }
        System.out.println("All Scores: " + scores);
        sc.close();
    }
}
