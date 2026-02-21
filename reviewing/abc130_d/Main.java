import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, K));

        sc.close();
    }

    static long solve(int[] a, long K) {
        long result = 0;
        int beginIndex = 0;
        long sum = 0;
        for (int endIndex = 0; endIndex < a.length; ++endIndex) {
            sum += a[endIndex];
            while (sum >= K) {
                sum -= a[beginIndex];
                ++beginIndex;
            }

            result += beginIndex;
        }

        return result;
    }
}