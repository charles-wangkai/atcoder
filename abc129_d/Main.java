import java.util.Scanner;

public class Main {
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

        System.out.println(solve(squares));

        sc.close();
    }

    static int solve(char[][] squares) {
        int H = squares.length;
        int W = squares[0].length;

        int[][] leftCounts = new int[H][W];
        for (int r = 0; r < H; ++r) {
            int leftCount = 0;
            for (int c = 0; c < W; ++c) {
                leftCounts[r][c] = leftCount;

                if (squares[r][c] == '.') {
                    ++leftCount;
                } else {
                    leftCount = 0;
                }
            }
        }

        int[][] rightCounts = new int[H][W];
        for (int r = 0; r < H; ++r) {
            int rightCount = 0;
            for (int c = W - 1; c >= 0; --c) {
                rightCounts[r][c] = rightCount;

                if (squares[r][c] == '.') {
                    ++rightCount;
                } else {
                    rightCount = 0;
                }
            }
        }

        int[][] upCounts = new int[H][W];
        for (int c = 0; c < W; ++c) {
            int upCount = 0;
            for (int r = 0; r < H; ++r) {
                upCounts[r][c] = upCount;

                if (squares[r][c] == '.') {
                    ++upCount;
                } else {
                    upCount = 0;
                }
            }
        }

        int[][] downCounts = new int[H][W];
        for (int c = 0; c < W; ++c) {
            int downCount = 0;
            for (int r = H - 1; r >= 0; --r) {
                downCounts[r][c] = downCount;

                if (squares[r][c] == '.') {
                    ++downCount;
                } else {
                    downCount = 0;
                }
            }
        }

        int result = 0;
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                if (squares[r][c] == '.') {
                    result = Math.max(result,
                            1 + leftCounts[r][c] + rightCounts[r][c] + upCounts[r][c] + downCounts[r][c]);
                }
            }
        }

        return result;
    }
}