import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < v.length; ++i) {
            v[i] = sc.nextInt();
        }

        System.out.println(solve(v));

        sc.close();
    }

    static int solve(int[] v) {
        List<Candidate> candidates1 = buildCandidates(
                IntStream.range(0, v.length).filter(i -> i % 2 == 0).map(i -> v[i]).toArray());
        List<Candidate> candidates2 = buildCandidates(
                IntStream.range(0, v.length).filter(i -> i % 2 != 0).map(i -> v[i]).toArray());

        int result = v.length;
        for (Candidate candidate1 : candidates1) {
            for (Candidate candidate2 : candidates2) {
                if (candidate1.value != candidate2.value) {
                    result = Math.min(result, v.length - candidate1.count - candidate2.count);
                }
            }
        }

        return result;
    }

    static List<Candidate> buildCandidates(int[] values) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int value : values) {
            valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
        }
        valueToCount.put(-1, 0);

        return valueToCount.keySet().stream()
                .sorted((value1, value2) -> -Integer.compare(valueToCount.get(value1), valueToCount.get(value2)))
                .limit(2).map(value -> new Candidate(value, valueToCount.get(value))).collect(Collectors.toList());
    }
}

class Candidate {
    int value;
    int count;

    Candidate(int value, int count) {
        this.value = value;
        this.count = count;
    }
}
