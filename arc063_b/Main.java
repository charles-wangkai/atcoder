import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A, T));

        sc.close();
    }

    static int solve(int[] A, int T) {
        int maxDiff = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int ai : A) {
            int diff = ai - min;
            if (diff > maxDiff) {
                maxDiff = diff;
                count = 1;
            } else if (diff == maxDiff) {
                ++count;
            }

            min = Math.min(min, ai);
        }

        return count;
    }
}