import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] t = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; ++i) {
            t[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        System.out.println(solve(t, d, K));

        sc.close();
    }

    static long solve(int[] t, int[] d, int K) {
        int[] sortedIndices = IntStream.range(0, t.length).boxed().sorted((i1, i2) -> -Integer.compare(d[i1], d[i2]))
                .mapToInt(x -> x).toArray();

        Set<Integer> kinds = new HashSet<>();
        long dSum = 0;
        Stack<Integer> extraDs = new Stack<>();

        for (int i = 0; i < K; ++i) {
            int index = sortedIndices[i];

            dSum += d[index];

            if (kinds.contains(t[index])) {
                extraDs.push(d[index]);
            } else {
                kinds.add(t[index]);
            }
        }

        long result = dSum + (long) kinds.size() * kinds.size();

        for (int i = K; i < sortedIndices.length; ++i) {
            int index = sortedIndices[i];

            if (!extraDs.empty() && !kinds.contains(t[index])) {
                dSum += d[index] - extraDs.pop();
                kinds.add(t[index]);

                result = Math.max(result, dSum + (long) kinds.size() * kinds.size());
            }
        }

        return result;
    }
}