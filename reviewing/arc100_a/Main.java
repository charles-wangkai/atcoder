import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
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

    static long solve(int[] A) {
        int[] regulated = IntStream.range(0, A.length).map(i -> A[i] - i - 1).sorted().toArray();

        return IntStream.range(0, A.length / 2).map(i -> regulated[A.length - 1 - i] - regulated[i]).asLongStream()
                .sum();
    }
}