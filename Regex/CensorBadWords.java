public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        for (String word : badWords) {
            input = input.replaceAll("(?i)" + word, "****");
        }
        System.out.println(input);
    }
}