import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(M, K));

        sc.close();
    }

    static String solve(int M, int K) {
        if (M == 0) {
            if (K == 0) {
                return "0 0";
            } else {
                return "-1";
            }
        }
        if (M == 1) {
            if (K == 0) {
                return "0 0 1 1";
            } else {
                return "-1";
            }
        }

        if (K >= 1 << M) {
            return "-1";
        }

        int[] result = new int[1 << (M + 1)];
        result[0] = K;
        result[1 << M] = K;

        int leftIndex = 1;
        int rightIndex = result.length - 1;
        for (int i = 0; i < 1 << M; ++i) {
            if (i != K) {
                result[leftIndex] = i;
                result[rightIndex] = i;

                ++leftIndex;
                --rightIndex;
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}