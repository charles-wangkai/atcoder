import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        System.out.println(solve(a, b, K));

        sc.close();
    }

    static int solve(int[] a, int[] b, long K) {
        int[] sortedIndices = IntStream.range(0, a.length).boxed().sorted((i1, i2) -> Integer.compare(a[i1], a[i2]))
                .mapToInt(x -> x).toArray();
        for (int i = 0;; ++i) {
            int sortedIndex = sortedIndices[i];
            if (b[sortedIndex] >= K) {
                return a[sortedIndex];
            }

            K -= b[sortedIndex];
        }
    }
}