import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] c = new int[N];
        int[] t = new int[N];
        for (int i = 0; i < N; ++i) {
            c[i] = sc.nextInt();
            t[i] = sc.nextInt();
        }

        System.out.println(solve(c, t, T));

        sc.close();
    }

    static String solve(int[] c, int[] t, int T) {
        OptionalInt minCost = IntStream.range(0, c.length).filter(i -> t[i] <= T).map(i -> c[i]).min();

        return minCost.isPresent() ? String.valueOf(minCost.getAsInt()) : "TLE";
    }
}