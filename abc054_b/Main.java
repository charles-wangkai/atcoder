import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] A = readGrid(sc, N);
        char[][] B = readGrid(sc, M);

        System.out.println(solve(A, B) ? "Yes" : "No");

        sc.close();
    }

    static char[][] readGrid(Scanner sc, int size) {
        char[][] result = new char[size][size];
        for (int r = 0; r < size; ++r) {
            String line = sc.next();
            for (int c = 0; c < size; ++c) {
                result[r][c] = line.charAt(c);
            }
        }

        return result;
    }

    static boolean solve(char[][] A, char[][] B) {
        int N = A.length;
        int M = B.length;

        for (int minR = 0; minR + M <= N; ++minR) {
            for (int minC = 0; minC + M <= N; ++minC) {
                if (isSame(A, B, minR, minC)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isSame(char[][] A, char[][] B, int minR, int minC) {
        int M = B.length;

        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < M; ++c) {
                if (A[minR + r][minC + c] != B[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}