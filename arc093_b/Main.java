import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int SIZE = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(A, B));

        sc.close();
    }

    static String solve(int A, int B) {
        char background;
        char foreground;
        int backCount;
        int foreCount;
        if (A <= B) {
            background = '.';
            foreground = '#';
            backCount = A;
            foreCount = B;
        } else {
            background = '#';
            foreground = '.';
            backCount = B;
            foreCount = A;
        }

        char[][] grids = new char[SIZE][SIZE];
        for (int r = 0; r < SIZE; ++r) {
            Arrays.fill(grids[r], background);
        }

        int r = 2;
        int c = 0;
        for (int i = 0; i < foreCount; ++i) {
            grids[r][c] = foreground;
            if (c % 4 == 0) {
                grids[r - 1][c] = foreground;
            } else {
                grids[r + 1][c - 1] = foreground;
                grids[r + 1][c] = foreground;
                grids[r + 1][c + 1] = foreground;
            }

            c += 2;
            if (c == SIZE - 2) {
                r += 4;
                c = 0;
            }
        }

        r = 1;
        c = 1;
        for (int i = 0; i < backCount - 1; ++i) {
            grids[r][c] = foreground;

            c += 2;
            if (c == SIZE - 3) {
                r += 3;
                c = 0;
            } else if (c == 2) {
                ++r;
                c = 1;
            }
        }

        return String.format("%d %d\n%s", SIZE, SIZE,
                Arrays.stream(grids).map(String::new).collect(Collectors.joining("\n")));
    }
}