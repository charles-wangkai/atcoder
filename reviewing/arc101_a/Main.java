import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < x.length; ++i) {
            x[i] = sc.nextInt();
        }

        System.out.println(solve(x, K));

        sc.close();
    }

    static int solve(int[] x, int K) {
        int middleIndex = 0;
        while (middleIndex != x.length && x[middleIndex] < 0) {
            ++middleIndex;
        }

        int middleIndex_ = middleIndex;
        int[] leftDistances = IntStream.range(0, middleIndex).map(i -> -x[middleIndex_ - 1 - i]).toArray();
        int[] rightDistances = IntStream.range(0, x.length - middleIndex).map(i -> x[middleIndex_ + i]).toArray();

        return Math.min(computeMinTime(K, leftDistances, rightDistances),
                computeMinTime(K, rightDistances, leftDistances));
    }

    static int computeMinTime(int K, int[] firstDistances, int[] secondDistances) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < firstDistances.length && i < K; ++i) {
            if (i == K - 1) {
                result = Math.min(result, firstDistances[i]);
            } else if (secondDistances.length >= K - i - 1) {
                result = Math.min(result, firstDistances[i] * 2 + secondDistances[K - i - 2]);
            }
        }

        return result;
    }
}