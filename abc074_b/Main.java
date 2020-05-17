import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < x.length; ++i) {
            x[i] = sc.nextInt();
        }

        System.out.println(solve(x, K));

        sc.close();
    }

    static int solve(int[] x, int K) {
        return 2 * Arrays.stream(x).map(xi -> Math.min(xi, K - xi)).sum();
    }
}