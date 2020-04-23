import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        System.out.println(solve(W, H, x, y, a));

        sc.close();
    }

    static int solve(int W, int H, int[] x, int[] y, int[] a) {
        boolean[][] grid = new boolean[H][W];
        for (int i = 0; i < x.length; ++i) {
            if (a[i] == 1) {
                for (int r = 0; r < H; ++r) {
                    for (int c = 0; c < x[i]; ++c) {
                        grid[r][c] = true;
                    }
                }
            } else if (a[i] == 2) {
                for (int r = 0; r < H; ++r) {
                    for (int c = x[i]; c < W; ++c) {
                        grid[r][c] = true;
                    }
                }
            } else if (a[i] == 3) {
                for (int r = 0; r < y[i]; ++r) {
                    for (int c = 0; c < W; ++c) {
                        grid[r][c] = true;
                    }
                }
            } else {
                for (int r = y[i]; r < H; ++r) {
                    for (int c = 0; c < W; ++c) {
                        grid[r][c] = true;
                    }
                }
            }
        }

        return Arrays.stream(grid).mapToInt(line -> (int) IntStream.range(0, W).filter(c -> !line[c]).count()).sum();
    }
}