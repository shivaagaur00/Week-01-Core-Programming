public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", " ", "Java"};
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
