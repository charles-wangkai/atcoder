import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N];
        for (int i = 0; i < T.length; ++i) {
            T[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] P = new int[M];
        int[] X = new int[M];
        for (int i = 0; i < M; ++i) {
            P[i] = sc.nextInt();
            X[i] = sc.nextInt();
        }

        System.out.println(solve(T, P, X));

        sc.close();
    }

    static String solve(int[] T, int[] P, int[] X) {
        int total = Arrays.stream(T).sum();

        return IntStream.range(0, P.length).mapToObj(i -> String.valueOf(total + X[i] - T[P[i] - 1]))
                .collect(Collectors.joining("\n"));
    }
}