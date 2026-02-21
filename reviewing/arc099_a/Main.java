import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A, K));

        sc.close();
    }

    static int solve(int[] A, int K) {
        int index1 = IntStream.range(0, A.length).filter(i -> A[i] == 1).findAny().getAsInt();

        return 1 + IntStream.rangeClosed(index1 - K + 1, index1)
                .filter(beginIndex -> beginIndex >= 0 && beginIndex + K <= A.length)
                .map(beginIndex -> (beginIndex + K - 2) / (K - 1) + (A.length - beginIndex - 2) / (K - 1)).min()
                .getAsInt();
    }
}