import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    static String solve(int[] A) {
        long M1 = 0;
        for (int i = 0; i < A.length; ++i) {
            M1 += ((i % 2 == 0) ? 1 : -1) * A[i];
        }

        int[] result = new int[A.length];
        result[0] = (int) M1;
        for (int i = 1; i < result.length; ++i) {
            result[i] = 2 * A[i - 1] - result[i - 1];
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}