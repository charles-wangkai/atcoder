import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int[] R_OFFSETS = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static final int[] C_OFFSETS = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] grid = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                grid[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(grid));

        sc.close();
    }

    static String solve(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == '.') {
                    grid[r][c] = '0';

                    for (int i = 0; i < R_OFFSETS.length; ++i) {
                        int adjR = r + R_OFFSETS[i];
                        int adjC = c + C_OFFSETS[i];

                        if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col && grid[adjR][adjC] == '#') {
                            ++grid[r][c];
                        }
                    }
                }
            }
        }

        return Arrays.stream(grid).map(String::valueOf).collect(Collectors.joining("\n"));
    }
}