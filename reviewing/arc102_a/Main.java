import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static long solve(int N, int K) {
        int[] counts = new int[K];
        for (int i = 1; i <= N; ++i) {
            ++counts[i % K];
        }

        return computeTripleNum(counts[0]) + ((K % 2 == 0) ? computeTripleNum(counts[K / 2]) : 0);
    }

    static long computeTripleNum(int count) {
        return (long) count * count * count;
    }
}