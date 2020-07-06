import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long D = sc.nextLong();
        long E = sc.nextLong();

        System.out.println(solve(N, A, B, C, D, E));

        sc.close();
    }

    static long solve(long N, long A, long B, long C, long D, long E) {
        return (N - 1) / LongStream.of(A, B, C, D, E).min().getAsLong() + 5;
    }
}