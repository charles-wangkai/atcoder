import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] t = new int[N];
        for (int i = 0; i < t.length; ++i) {
            t[i] = sc.nextInt();
        }

        System.out.println(solve(t, T));

        sc.close();
    }

    static long solve(int[] t, int T) {
        long result = 0;
        int prev = 0;
        for (int ti : t) {
            result += Math.min(T, ti + T - prev);
            prev = ti + T;
        }

        return result;
    }
}