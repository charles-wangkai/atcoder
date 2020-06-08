import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long C = sc.nextLong();
        long[] x = new long[N];
        int[] v = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextLong();
            v[i] = sc.nextInt();
        }

        System.out.println(solve(x, v, C));

        sc.close();
    }

    static long solve(long[] x, int[] v, long C) {
        return Math.max(solveFirstClockwise(x, v, C),
                solveFirstClockwise(reverse(Arrays.stream(x).map(xi -> C - xi).toArray()), reverse(v), C));
    }

    static long[] reverse(long[] a) {
        for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return a;
    }

    static int[] reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return a;
    }

    static long solveFirstClockwise(long[] x, int[] v, long C) {
        int N = x.length;

        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> -Long.compare(e1.gain, e2.gain));
        long counterClockwiseEnergySum = 0;
        for (int i = N - 1; i >= 0; --i) {
            counterClockwiseEnergySum += v[i];
            long gain = counterClockwiseEnergySum - (C - x[i]);

            pq.offer(new Element(x[i], gain));
        }

        long result = Math.max(0, pq.peek().gain);
        long clockwiseEnergySum = 0;
        for (int i = 0; i < N; ++i) {
            clockwiseEnergySum += v[i];
            long balance = clockwiseEnergySum - x[i];

            while (!pq.isEmpty() && pq.peek().clockwiseDistance <= x[i]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                balance += Math.max(0, pq.peek().gain - x[i]);
            }

            result = Math.max(result, balance);
        }

        return result;
    }
}

class Element {
    long clockwiseDistance;
    long gain;

    Element(long clockwiseDistance, long gain) {
        this.clockwiseDistance = clockwiseDistance;
        this.gain = gain;
    }
}