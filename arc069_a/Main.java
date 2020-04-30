import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        System.out.println(solve(N, M));

        sc.close();
    }

    static long solve(long N, long M) {
        return Math.min(N, M / 2) + (M - Math.min(N, M / 2) * 2) / 4;
    }
}