import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] X = new int[M];
        for (int i = 0; i < X.length; ++i) {
            X[i] = sc.nextInt();
        }

        System.out.println(solve(N, X));

        sc.close();
    }

    static int solve(int N, int[] X) {
        X = Arrays.stream(X).boxed().sorted().mapToInt(x -> x).toArray();

        int[] X_ = X;
        return IntStream.range(0, X.length - 1).map(i -> X_[i + 1] - X_[i]).sorted().limit(Math.max(0, X.length - N))
                .sum();
    }
}