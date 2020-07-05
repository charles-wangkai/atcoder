import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final int MODULUS = 1_000_000_007;
    static final char[] ALPHABET = { 'A', 'C', 'G', 'T' };
    static final Set<String> EXCLUDED_PATTERNS = new HashSet<>(
            Arrays.asList("AGC", "GAC", "ACG", "AGGC", "ATGC", "AGTC"));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        Map<String, Integer> patternToWayNum = new HashMap<>();
        patternToWayNum.put("", 1);

        for (int i = 0; i < N; ++i) {
            Map<String, Integer> nextPatternToWayNum = new HashMap<>();
            for (String pattern : patternToWayNum.keySet()) {
                for (char letter : ALPHABET) {
                    String nextPattern = pattern + letter;
                    if (nextPattern.length() > 4) {
                        nextPattern = nextPattern.substring(nextPattern.length() - 4);
                    }
                    String nextLastThreePattern = (nextPattern.length() == 4) ? nextPattern.substring(1) : nextPattern;

                    if (!EXCLUDED_PATTERNS.contains(nextPattern) && !EXCLUDED_PATTERNS.contains(nextLastThreePattern)) {
                        nextPatternToWayNum.put(nextPattern,
                                addMod(nextPatternToWayNum.getOrDefault(nextPattern, 0), patternToWayNum.get(pattern)));
                    }
                }
            }

            patternToWayNum = nextPatternToWayNum;
        }

        return patternToWayNum.values().stream().mapToInt(x -> x).reduce(Main::addMod).getAsInt();
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }
}