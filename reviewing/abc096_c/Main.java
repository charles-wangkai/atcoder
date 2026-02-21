import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int[] R_OFFSETS = { -1, 0, 1, 0 };
    static final int[] C_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] squares = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                squares[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(squares) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(char[][] squares) {
        int H = squares.length;
        int W = squares[0].length;

        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                int r_ = r;
                int c_ = c;
                if (squares[r][c] == '#' && !IntStream.range(0, R_OFFSETS.length).anyMatch(i -> {
                    int adjR = r_ + R_OFFSETS[i];
                    int adjC = c_ + C_OFFSETS[i];

                    return adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && squares[adjR][adjC] == '#';
                })) {
                    return false;
                }
            }
        }

        return true;
    }
}