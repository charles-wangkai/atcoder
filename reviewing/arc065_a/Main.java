import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final String[] WORDS = { "dream", "dreamer", "erase", "eraser" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(String S) {
        int length = S.length();
        while (length != 0) {
            boolean matched = false;
            for (String word : WORDS) {
                if (isSuffix(S, length, word)) {
                    length -= word.length();
                    matched = true;
                }
            }

            if (!matched) {
                return false;
            }
        }

        return true;
    }

    static boolean isSuffix(String S, int length, String word) {
        return length >= word.length() && IntStream.range(0, word.length())
                .allMatch(i -> S.charAt(length - word.length() + i) == word.charAt(i));
    }
}