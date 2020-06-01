import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int[] R_OFFSETS = { -1, 0, 1, 0 };
    static final int[] C_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] colors = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                colors[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(colors));

        sc.close();
    }

    static int solve(char[][] colors) {
        int H = colors.length;
        int W = colors[0].length;

        int[][] distances = new int[H][W];
        for (int r = 0; r < H; ++r) {
            Arrays.fill(distances[r], -1);
        }
        distances[0][0] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point head = queue.poll();
            if (head.r == H - 1 && head.c == W - 1) {
                return Arrays.stream(colors)
                        .mapToInt(row -> (int) IntStream.range(0, W).filter(c -> row[c] == '.').count()).sum()
                        - (distances[H - 1][W - 1] + 1);
            }

            for (int i = 0; i < R_OFFSETS.length; ++i) {
                int adjR = head.r + R_OFFSETS[i];
                int adjC = head.c + C_OFFSETS[i];

                if (adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && colors[adjR][adjC] == '.'
                        && distances[adjR][adjC] == -1) {
                    distances[adjR][adjC] = distances[head.r][head.c] + 1;
                    queue.offer(new Point(adjR, adjC));
                }
            }
        }

        return -1;
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}