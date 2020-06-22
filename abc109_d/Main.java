import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] a = new int[H][W];
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                a[r][c] = sc.nextInt();
            }
        }

        System.out.println(solve(a));

        sc.close();
    }

    static String solve(int[][] a) {
        int H = a.length;
        int W = a[0].length;

        List<String> operations = new ArrayList<>();
        int r = 0;
        int c = 0;
        int offsetC = 1;
        while (r != H) {
            int nextR = r;
            int nextC = c + offsetC;
            if (nextC == -1 || nextC == W) {
                ++nextR;
                offsetC *= -1;
                nextC += offsetC;
            }

            if (a[r][c] % 2 != 0) {
                --a[r][c];

                if (nextR != H) {
                    ++a[nextR][nextC];

                    operations.add(String.format("%d %d %d %d", r + 1, c + 1, nextR + 1, nextC + 1));
                }
            }

            r = nextR;
            c = nextC;
        }

        return String.format("%d\n%s", operations.size(), String.join("\n", operations));
    }
}