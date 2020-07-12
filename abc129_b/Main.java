import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] W = new int[N];
        for (int i = 0; i < W.length; ++i) {
            W[i] = sc.nextInt();
        }

        System.out.println(solve(W));

        sc.close();
    }

    static int solve(int[] W) {
        int total = Arrays.stream(W).sum();
        int result = Integer.MAX_VALUE;
        int leftSum = 0;
        for (int i = 0; i < W.length - 1; ++i) {
            leftSum += W[i];

            result = Math.min(result, Math.abs(total - leftSum - leftSum));
        }

        return result;
    }
}