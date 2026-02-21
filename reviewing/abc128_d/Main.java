import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] V = new int[N];
        for (int i = 0; i < V.length; ++i) {
            V[i] = sc.nextInt();
        }

        System.out.println(solve(V, K));

        sc.close();
    }

    static int solve(int[] V, int K) {
        int result = 0;
        for (int leftLength = 0; leftLength <= V.length; ++leftLength) {
            for (int rightLength = 0; rightLength <= Math.min(V.length, K) - leftLength; ++rightLength) {
                int sum = 0;
                PriorityQueue<Integer> negatives = new PriorityQueue<>();
                for (int i = 0; i < leftLength; ++i) {
                    sum += V[i];
                    if (V[i] < 0) {
                        negatives.offer(V[i]);
                    }
                }
                for (int i = V.length - rightLength; i < V.length; ++i) {
                    sum += V[i];
                    if (V[i] < 0) {
                        negatives.offer(V[i]);
                    }
                }

                for (int i = 0; i < K - leftLength - rightLength; ++i) {
                    if (!negatives.isEmpty()) {
                        sum -= negatives.poll();
                    }
                }

                result = Math.max(result, sum);
            }
        }

        return result;
    }
}