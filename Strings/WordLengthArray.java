import java.util.*;

public class WordLengthArray {
    public static String[] splitWords(String s) {
        s += " ";
        int count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == ' ') count++;
        String[] words = new String[count];
        int idx = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words[idx++] = s.substring(start, i);
                start = i + 1;
            }
        }
        return words;
    }

    public static int getLength(String s) {
        int i = 0;
        try {
            while (true) s.charAt(i++);
        } catch (Exception e) {}
        return i;
    }

    public static String[][] getWordLength(String[] words) {
        String[][] arr = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(getLength(words[i]));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = splitWords(s);
        String[][] result = getWordLength(words);
        System.out.println("Word\tLength");
        for (String[] row : result)
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
    }
}
