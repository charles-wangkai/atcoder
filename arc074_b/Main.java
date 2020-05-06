import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[3 * N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static long solve(int[] a) {
        long[] leftSums = buildLeftSums(a);
        long[] rightSums = buildRightSums(a);

        return IntStream.range(0, a.length - 1).filter(i -> leftSums[i] != -1 && rightSums[i + 1] != -1)
                .mapToLong(i -> leftSums[i] - rightSums[i + 1]).max().getAsLong();
    }

    static long[] buildLeftSums(int[] a) {
        int N = a.length / 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        long[] result = new long[a.length];
        for (int i = 0; i < result.length; ++i) {
            if (pq.size() == N && pq.peek() < a[i]) {
                sum -= pq.poll();
            }
            if (pq.size() != N) {
                pq.offer(a[i]);
                sum += a[i];
            }

            result[i] = (pq.size() == N) ? sum : -1;
        }

        return result;
    }

    static long[] buildRightSums(int[] a) {
        int N = a.length / 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        long[] result = new long[a.length];
        for (int i = a.length - 1; i >= 0; --i) {
            if (pq.size() == N && pq.peek() > a[i]) {
                sum -= pq.poll();
            }
            if (pq.size() != N) {
                pq.offer(a[i]);
                sum += a[i];
            }

            result[i] = (pq.size() == N) ? sum : -1;
        }

        return result;
    }
}