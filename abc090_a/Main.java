import java.util.Scanner;

public class Main {
    static final int SIZE = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] c = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            String line = sc.next();
            for (int j = 0; j < SIZE; ++j) {
                c[i][j] = line.charAt(j);
            }
        }

        System.out.println(solve(c));

        sc.close();
    }

    static String solve(char[][] c) {
        return String.format("%c%c%c", c[0][0], c[1][1], c[2][2]);
    }
}