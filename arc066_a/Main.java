import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static int solve(int[] A) {
        A = Arrays.stream(A).boxed().sorted().mapToInt(x -> x).toArray();

        int[] A_ = A;
        return IntStream.range(0, A.length).allMatch(i -> A_[i] == (i + A_.length % 2) / 2 * 2 + (1 - A_.length % 2))
                ? IntStream.range(0, A.length / 2).map(i -> 2).reduce(1, Main::multiplyMod)
                : 0;
    }

    static int multiplyMod(int x, int y) {
        return (int) ((long) x * y % MODULUS);
    }
}