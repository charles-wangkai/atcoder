import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] S = new String[n];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next();
        }

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String[] S) {
        int[] counts = new int[26];
        Arrays.fill(counts, Integer.MAX_VALUE);

        for (String Si : S) {
            int[] c = new int[26];
            for (char ch : Si.toCharArray()) {
                ++c[ch - 'a'];
            }

            for (int i = 0; i < counts.length; ++i) {
                counts[i] = Math.min(counts[i], c[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counts.length; ++i) {
            for (int j = 0; j < counts[i]; ++j) {
                result.append((char) ('a' + i));
            }
        }

        return result.toString();
    }
}