import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int[] A = new int[M];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(N, A, X));

        sc.close();
    }

    static int solve(int N, int[] A, int X) {
        Set<Integer> gates = Arrays.stream(A).boxed().collect(Collectors.toSet());

        return Math.min((int) IntStream.range(1, X).filter(gates::contains).count(),
                (int) IntStream.range(X + 1, N).filter(gates::contains).count());
    }
}