import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static long solve(int[] A) {
        Map<Integer, Integer> lengthToCount = new HashMap<>();
        for (int length : A) {
            lengthToCount.put(length, lengthToCount.getOrDefault(length, 0) + 1);
        }

        int[] sortedLengths = lengthToCount.keySet().stream().filter(length -> lengthToCount.get(length) >= 2)
                .flatMap(length -> (lengthToCount.get(length) >= 4) ? Stream.of(length, length) : Stream.of(length))
                .sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

        return (sortedLengths.length >= 2) ? ((long) sortedLengths[0] * sortedLengths[1]) : 0;
    }
}