import java.util.*;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int c = (int) (Math.random() * 3);
        if (c == 0) return "rock";
        else if (c == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if (user.equals("rock") && computer.equals("scissors")) return "user";
        if (user.equals("paper") && computer.equals("rock")) return "user";
        if (user.equals("scissors") && computer.equals("paper")) return "user";
        return "computer";
    }

    public static String[][] getStats(String[] results) {
        int user = 0, computer = 0, draw = 0;
        for (String res : results) {
            if (res.equals("user")) user++;
            else if (res.equals("computer")) computer++;
            else draw++;
        }
        int total = results.length;
        String[][] arr = {
            {"User Wins", String.valueOf(user)},
            {"Computer Wins", String.valueOf(computer)},
            {"Draws", String.valueOf(draw)},
            {"User Win %", String.valueOf((user * 100) / total)},
            {"Computer Win %", String.valueOf((computer * 100) / total)}
        };
        return arr;
    }

    public static void display(String[][] stats, String[] results) {
        System.out.println("Game\tResult");
        for (int i = 0; i < results.length; i++)
            System.out.println((i + 1) + "\t" + results[i]);
        System.out.println("\nSummary:");
        for (String[] row : stats)
            System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            String user = sc.next().toLowerCase();
            String computer = getComputerChoice();
            results[i] = findWinner(user, computer);
        }
        String[][] stats = getStats(results);
        display(stats, results);
    }
}
