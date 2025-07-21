public class ComparePerformance {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < 1000000; i++) sb1.append("hello");
        long end1 = System.nanoTime();
        System.out.println("StringBuffer: " + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 1000000; i++) sb2.append("hello");
        long end2 = System.nanoTime();
        System.out.println("StringBuilder: " + (end2 - start2) + " ns");
    }
}
