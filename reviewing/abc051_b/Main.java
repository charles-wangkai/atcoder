import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int S = sc.nextInt();

        System.out.println(solve(K, S));

        sc.close();
    }

    static int solve(int K, int S) {
        return IntStream.rangeClosed(0, K)
                .map(x -> (int) IntStream.rangeClosed(0, K).filter(y -> S - x - y >= 0 && S - x - y <= K).count())
                .sum();
    }
}