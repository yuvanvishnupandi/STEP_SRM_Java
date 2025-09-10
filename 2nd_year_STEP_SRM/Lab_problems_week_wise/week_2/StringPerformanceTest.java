//Problem 3: Analyze performance of String concatenation vs StringBuilder vs StringBuffer
import java.util.Scanner;

public class StringPerformanceTest {

    public static long[] testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) s = s + "a";
        long end = System.currentTimeMillis();
        return new long[] { end - start, s.length() };
    }

    public static long[] testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("a");
        long end = System.currentTimeMillis();
        return new long[] { end - start, sb.length() };
    }

    public static long[] testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) sb.append("a");
        long end = System.currentTimeMillis();
        return new long[] { end - start, sb.length() };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations:");
        int n = sc.nextInt();

        long[] concatRes = testStringConcat(n);
        long[] builderRes = testStringBuilder(n);
        long[] bufferRes = testStringBuffer(n);

        System.out.printf("%-20s %-20s %-20s%n", "Method", "Time (ms)", "String Length");
        System.out.printf("%-20s %-20d %-20d%n", "String Concatenation", concatRes[0], concatRes[1]);
        System.out.printf("%-20s %-20d %-20d%n", "StringBuilder", builderRes[0], builderRes[1]);
        System.out.printf("%-20s %-20d %-20d%n", "StringBuffer", bufferRes[0], bufferRes[1]);

        sc.close();
    }
}
