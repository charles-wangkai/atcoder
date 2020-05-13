import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(H, W, a));

        sc.close();
    }

    static String solve(int H, int W, int[] a) {
        int[][] colors = new int[H][W];
        int r = 0;
        int c = 0;
        int offsetC = 1;
        int index = 0;

        while (r != H) {
            colors[r][c] = index + 1;

            c += offsetC;
            if (c == -1 || c == W) {
                ++r;
                c -= offsetC;
                offsetC *= -1;
            }

            --a[index];
            if (a[index] == 0) {
                ++index;
            }
        }

        return Arrays.stream(colors)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}