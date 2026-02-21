import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] X = new int[N];
        for (int i = 0; i < X.length; ++i) {
            X[i] = sc.nextInt();
        }

        System.out.println(solve(X, A, B));

        sc.close();
    }

    static long solve(int[] X, int A, int B) {
        return IntStream.range(0, X.length - 1).mapToLong(i -> Math.min((long) A * (X[i + 1] - X[i]), B)).sum();
    }
}