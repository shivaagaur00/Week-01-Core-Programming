import java.util.regex.*;
import java.util.*;

public class ExtractEmails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Matcher m = Pattern.compile("[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}