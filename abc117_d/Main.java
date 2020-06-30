import java.util.Scanner;

public class Main {
    static final int LIMIT = 40;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();
        long[] A = new long[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextLong();
        }

        System.out.println(solve(A, K));

        sc.close();
    }

    static long solve(long[] A, long K) {
        int[] count0s = new int[LIMIT + 1];
        int[] count1s = new int[LIMIT + 1];
        for (long Ai : A) {
            for (int i = 0; i <= LIMIT; ++i) {
                if ((Ai & (1L << i)) == 0) {
                    ++count0s[i];
                } else {
                    ++count1s[i];
                }
            }
        }

        long result = -1;
        long sum = 0;
        for (int i = LIMIT; i >= 0; --i) {
            long power = 1L << i;

            if (K >= power) {
                long nextSum = count1s[i] * power;
                for (int j = 0; j < i; ++j) {
                    nextSum += Math.max(count0s[j], count1s[j]) * (1L << j);
                }
                result = Math.max(result, sum + nextSum);

                sum += count0s[i] * power;
                K -= power;
            } else {
                sum += count1s[i] * power;
            }
        }
        result = Math.max(result, sum);

        return result;
    }
}