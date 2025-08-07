import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Matcher m = Pattern.compile("\b(\w+)\b\s+\1\b", Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}