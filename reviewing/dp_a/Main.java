import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < h.length; ++i) {
            h[i] = sc.nextInt();
        }

        System.out.println(solve(h));

        sc.close();
    }

    static int solve(int[] h) {
        int[] costs = new int[h.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;

        for (int i = 1; i < costs.length; ++i) {
            for (int j = 1; j <= 2 && j <= i; ++j) {
                costs[i] = Math.min(costs[i], costs[i - j] + Math.abs(h[i] - h[i - j]));
            }
        }

        return costs[costs.length - 1];
    }
}