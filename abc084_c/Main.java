import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] C = new int[N - 1];
        int[] S = new int[N - 1];
        int[] F = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            C[i] = sc.nextInt();
            S[i] = sc.nextInt();
            F[i] = sc.nextInt();
        }

        System.out.println(solve(C, S, F));

        sc.close();
    }

    static String solve(int[] C, int[] S, int[] F) {
        int N = C.length + 1;

        int[] result = new int[N];
        for (int i = 0; i < result.length; ++i) {
            int time = 0;
            for (int j = i; j < N - 1; ++j) {
                time = Math.max((time + F[j] - 1) / F[j] * F[j], S[j]) + C[j];
            }

            result[i] = time;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}