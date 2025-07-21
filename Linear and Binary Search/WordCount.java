import java.io.*;
public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        String word = "java";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\s+");
            for (String w : words) {
                if (w.equalsIgnoreCase(word)) count++;
            }
        }
        br.close();
        System.out.println("Word count: " + count);
    }
}
