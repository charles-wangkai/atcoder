import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        System.out.println(solve(A, B, M));

        sc.close();
    }

    static long solve(int[] A, int[] B, int M) {
        int[] sortedIndices = IntStream.range(0, A.length).boxed().sorted((i1, i2) -> Integer.compare(A[i1], A[i2]))
                .mapToInt(x -> x).toArray();

        long result = 0;
        for (int index : sortedIndices) {
            int count = Math.min(B[index], M);
            result += (long) A[index] * count;

            M -= count;
        }

        return result;
    }
}