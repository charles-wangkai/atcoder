import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N];
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            T[i] = sc.nextInt();
            A[i] = sc.nextInt();
        }

        System.out.println(solve(T, A));

        sc.close();
    }

    static long solve(int[] T, int[] A) {
        long t = 1;
        long a = 1;
        for (int i = 0; i < T.length; ++i) {
            long factor = Math.max(divideToCeil(t, T[i]), divideToCeil(a, A[i]));

            t = T[i] * factor;
            a = A[i] * factor;
        }

        return t + a;
    }

    static long divideToCeil(long x, int y) {
        return (x + y - 1) / y;
    }
}