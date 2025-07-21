import java.util.Scanner;
public class SearchWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sentences = {"Java is fun", "Learning is continuous", "Practice makes perfect"};
        String word = sc.nextLine();
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                System.out.println(sentence);
                return;
            }
        }
        System.out.println("Not Found");
    }
}
