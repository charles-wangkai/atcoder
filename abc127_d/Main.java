import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[M];
        int[] C = new int[M];
        for (int i = 0; i < M; ++i) {
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        System.out.println(solve(A, B, C));

        sc.close();
    }

    static long solve(int[] A, int[] B, int[] C) {
        A = Arrays.stream(A).boxed().sorted().mapToInt(x -> x).toArray();
        int[] sortedIndices = IntStream.range(0, B.length).boxed().sorted((i1, i2) -> -Integer.compare(C[i1], C[i2]))
                .mapToInt(x -> x).toArray();

        int index = 0;
        for (int i = 0; i < A.length; ++i) {
            if (index != sortedIndices.length && C[sortedIndices[index]] > A[i]) {
                A[i] = C[sortedIndices[index]];

                --B[sortedIndices[index]];
                if (B[sortedIndices[index]] == 0) {
                    ++index;
                }
            }
        }

        return Arrays.stream(A).asLongStream().sum();
    }
}