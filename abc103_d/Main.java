import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        System.out.println(solve(N, a, b));

        sc.close();
    }

    static int solve(int N, int[] a, int[] b) {
        int[] sortedIndices = IntStream.range(0, a.length).boxed().sorted((i1, i2) -> Integer.compare(b[i1], b[i2]))
                .mapToInt(x -> x).toArray();

        int result = 0;
        int prevEnd = -1;
        for (int index : sortedIndices) {
            if (a[index] >= prevEnd) {
                ++result;
                prevEnd = b[index];
            }
        }

        return result;
    }
}