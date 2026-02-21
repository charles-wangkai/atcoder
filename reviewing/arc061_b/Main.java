import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static final int BASE = 1_000_000_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        Set<Long> blacks = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            blacks.add(encode(a, b));
        }

        System.out.println(solve(H, W, blacks));

        sc.close();
    }

    static String solve(int H, int W, Set<Long> blacks) {
        Set<Long> centers = new HashSet<>();
        for (long black : blacks) {
            int blackR = (int) (black / BASE);
            int blackC = (int) (black % BASE);

            for (int dr = -1; dr <= 1; ++dr) {
                for (int dc = -1; dc <= 1; ++dc) {
                    int centerR = blackR + dr;
                    int centerC = blackC + dc;

                    if (centerR >= 2 && centerR <= H - 1 && centerC >= 2 && centerC <= W - 1) {
                        centers.add(encode(centerR, centerC));
                    }
                }
            }
        }

        long[] result = new long[10];
        for (long center : centers) {
            int centerR = (int) (center / BASE);
            int centerC = (int) (center % BASE);

            int count = 0;
            for (int dr = -1; dr <= 1; ++dr) {
                for (int dc = -1; dc <= 1; ++dc) {
                    int r = centerR + dr;
                    int c = centerC + dc;
                    if (blacks.contains(encode(r, c))) {
                        ++count;
                    }
                }
            }

            ++result[count];
        }

        result[0] = (H - 2L) * (W - 2) - Arrays.stream(result).sum();

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    static long encode(int r, int c) {
        return (long) r * BASE + c;
    }
}