import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int SIZE = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] c = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                c[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(c) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int[][] c) {
        return IntStream.range(0, SIZE).map(i -> c[i][1] - c[i][0]).distinct().count() == 1
                && IntStream.range(0, SIZE).map(i -> c[i][2] - c[i][1]).distinct().count() == 1
                && IntStream.range(0, SIZE).map(j -> c[1][j] - c[0][j]).distinct().count() == 1
                && IntStream.range(0, SIZE).map(j -> c[2][j] - c[1][j]).distinct().count() == 1;
    }
}