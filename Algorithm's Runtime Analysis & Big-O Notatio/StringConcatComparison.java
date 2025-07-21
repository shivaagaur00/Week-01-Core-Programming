public class StringConcatComparison {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < 10000; i++) str += "a";
        long end = System.nanoTime();
        System.out.println("String + Concatenation: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder Append: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) buffer.append("a");
        end = System.nanoTime();
        System.out.println("StringBuffer Append: " + (end - start) / 1e6 + " ms");
    }
}
