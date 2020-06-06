import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(A, B, K));

        sc.close();
    }

    static String solve(int A, int B, int K) {
        return IntStream
                .concat(IntStream.rangeClosed(A, Math.min(B, A + K - 1)),
                        IntStream.rangeClosed(Math.max(A, B - K + 1), B))
                .distinct().sorted().mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}