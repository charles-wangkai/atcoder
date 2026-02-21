import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static long solve(int[] a) {
        long total = Arrays.stream(a).asLongStream().sum();

        long result = Long.MAX_VALUE;
        long leftSum = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            leftSum += a[i];
            long rightSum = total - leftSum;

            result = Math.min(result, Math.abs(leftSum - rightSum));
        }

        return result;
    }
}