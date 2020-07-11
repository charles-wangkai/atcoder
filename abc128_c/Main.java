import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] s = new int[M][];
        for (int i = 0; i < s.length; ++i) {
            int k = sc.nextInt();
            s[i] = new int[k];
            for (int j = 0; j < s[i].length; ++j) {
                s[i][j] = sc.nextInt() - 1;
            }
        }
        int[] p = new int[M];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt();
        }

        System.out.println(solve(N, s, p));

        sc.close();
    }

    static int solve(int N, int[][] s, int[] p) {
        int result = 0;
        for (int code = 0; code < 1 << N; ++code) {
            int code_ = code;
            if (IntStream.range(0, s.length)
                    .allMatch(i -> Arrays.stream(s[i]).filter(j -> (code_ & (1 << j)) != 0).count() % 2 == p[i])) {
                ++result;
            }
        }

        return result;
    }
}