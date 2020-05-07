import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < h.length; ++i) {
            h[i] = sc.nextInt();
        }

        System.out.println(solve(h, A, B));

        sc.close();
    }

    static int solve(int[] h, int A, int B) {
        int result = -1;
        int lower = 1;
        int upper = Arrays.stream(h).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;

            if (check(h, A, B, middle)) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }

    static boolean check(int[] h, int A, int B, int round) {
        return Arrays.stream(h).mapToLong(hi -> divideToCeil(Math.max(0, hi - (long) B * round), A - B)).sum() <= round;
    }

    static long divideToCeil(long x, long y) {
        return (x + y - 1) / y;
    }
}