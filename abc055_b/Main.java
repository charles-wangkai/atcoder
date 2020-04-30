import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        return IntStream.rangeClosed(1, N).reduce((x, y) -> (int) ((long) x * y % MODULUS)).getAsInt();
    }
}