import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] P = new int[M];
        int[] Y = new int[M];
        for (int i = 0; i < M; ++i) {
            P[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }

        System.out.println(solve(N, P, Y));

        sc.close();
    }

    static String solve(int N, int[] P, int[] Y) {
        String[] result = new String[P.length];
        int[] counts = new int[N + 1];
        int[] sortedIndices = IntStream.range(0, P.length).boxed().sorted((i1, i2) -> Integer.compare(Y[i1], Y[i2]))
                .mapToInt(x -> x).toArray();
        for (int index : sortedIndices) {
            ++counts[P[index]];
            result[index] = String.format("%06d%06d", P[index], counts[P[index]]);
        }

        return String.join("\n", result);
    }
}