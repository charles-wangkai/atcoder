import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] t = new int[N];
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; ++i) {
            t[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        System.out.println(solve(t, x, y) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int[] t, int[] x, int[] y) {
        return IntStream.range(0, t.length).allMatch(i -> {
            int distance = Math.abs(x[i] - (i == 0 ? 0 : x[i - 1])) + Math.abs(y[i] - (i == 0 ? 0 : y[i - 1]));
            int time = t[i] - (i == 0 ? 0 : t[i - 1]);

            return distance <= time && (time - distance) % 2 == 0;
        });
    }
}