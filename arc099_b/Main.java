import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        System.out.println(solve(K));

        sc.close();
    }

    static String solve(int K) {
        List<Long> candidates = new ArrayList<>();
        for (int prefix = 0; prefix <= 999; ++prefix) {
            long candidate = prefix;
            for (int suffixLength = 0; suffixLength <= 15; ++suffixLength) {
                candidates.add(candidate);
                candidate = candidate * 10 + 9;
            }
        }
        candidates = candidates.stream().distinct().sorted().collect(Collectors.toList());

        List<Long> solutions = new ArrayList<>();
        double minFactor = Double.MAX_VALUE;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            double factor = computeFactor(candidates.get(i));
            if (factor <= minFactor) {
                solutions.add(candidates.get(i));
                minFactor = factor;
            }
        }
        Collections.reverse(solutions);

        return solutions.stream().limit(K).map(String::valueOf).collect(Collectors.joining("\n"));
    }

    static double computeFactor(long x) {
        return (double) x / String.valueOf(x).chars().map(ch -> ch - '0').sum();
    }
}