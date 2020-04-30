import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, K));

        sc.close();
    }

    static int solve(int[] a, int K) {
        Arrays.sort(a);

        int lastIndex = -1;
        int lower = 0;
        int upper = a.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;

            if (isUnnecessary(a, K, middle)) {
                lastIndex = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return lastIndex + 1;
    }

    static boolean isUnnecessary(int[] a, int K, int index) {
        if (a[index] >= K) {
            return false;
        }

        boolean[] sums = new boolean[K];
        sums[0] = true;

        for (int i = 0; i < a.length; ++i) {
            if (i != index) {
                boolean[] nextSums = new boolean[K];
                for (int j = 0; j < nextSums.length; ++j) {
                    nextSums[j] = sums[j] || (j >= a[i] && sums[j - a[i]]);

                    if (nextSums[j] && j + a[index] >= K) {
                        return false;
                    }
                }

                sums = nextSums;
            }
        }

        return true;
    }
}