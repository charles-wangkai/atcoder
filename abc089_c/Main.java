import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final char[] BEGINS = { 'M', 'A', 'R', 'C', 'H' };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next();
        }

        System.out.println(solve(S));

        sc.close();
    }

    static long solve(String[] S) {
        Map<Character, Integer> beginToCount = new HashMap<>();
        for (String name : S) {
            char begin = name.charAt(0);

            beginToCount.put(begin, beginToCount.getOrDefault(begin, 0) + 1);
        }

        long result = 0;
        for (int i = 0; i < BEGINS.length; ++i) {
            for (int j = i + 1; j < BEGINS.length; ++j) {
                for (int k = j + 1; k < BEGINS.length; ++k) {
                    result += (long) beginToCount.getOrDefault(BEGINS[i], 0) * beginToCount.getOrDefault(BEGINS[j], 0)
                            * beginToCount.getOrDefault(BEGINS[k], 0);
                }
            }
        }

        return result;
    }
}