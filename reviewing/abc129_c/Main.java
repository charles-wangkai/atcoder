import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(N, a));

        sc.close();
    }

    static int solve(int N, int[] a) {
        int[] wayNums = new int[N + 1];
        wayNums[0] = 1;

        boolean[] brokens = new boolean[N + 1];
        for (int ai : a) {
            brokens[ai] = true;
        }

        for (int i = 0; i < wayNums.length; ++i) {
            for (int j = 1; j <= 2; ++j) {
                if (i + j < wayNums.length && !brokens[i + j]) {
                    wayNums[i + j] = addMod(wayNums[i + j], wayNums[i]);
                }
            }
        }

        return wayNums[N];
    }

    static int addMod(int x, int y) {
        return (x + y) % MODULUS;
    }
}