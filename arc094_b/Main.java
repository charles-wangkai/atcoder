import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        for (int tc = 0; tc < Q; ++tc) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(solve(A, B));
        }

        sc.close();
    }

    static int solve(int A, int B) {
        if (A > B) {
            return solve(B, A);
        }

        int result = -1;
        int lower = 0;
        int upper = A + B - 2;
        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;
            if (check(A, B, middle)) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }

    static boolean check(int A, int B, int x) {
        long productLimit = (long) A * B;

        if (x < A) {
            return checkPiece(productLimit, 1, x, x, 1);
        } else if (x < B) {
            return checkPiece(productLimit, 1, A - 1, x, x - A + 2)
                    && checkPiece(productLimit, A + 1, x + 1, x - A + 1, 1);
        } else {
            if (A + B == x + 2) {
                return checkPiece(productLimit, 1, A - 1, x + 1, B + 1)
                        && checkPiece(productLimit, A + 1, x + 1, B - 1, 1);
            } else {
                return checkPiece(productLimit, 1, x - B + 1, x + 1, B + 1)
                        && checkPiece(productLimit, x - B + 2, A - 1, B - 1, x - A + 2)
                        && checkPiece(productLimit, A + 1, x + 1, x - A + 1, 1);
            }
        }
    }

    static boolean checkPiece(long productLimit, int beginA, int endA, int beginB, int endB) {
        int middleA = (beginA + beginB) / 2;
        int middleB = beginA + beginB - middleA;

        return checkPoint(productLimit, beginA, beginB) && checkPoint(productLimit, endA, endB)
                && (!(middleA >= beginA && middleA <= endA && middleB <= beginB && middleB >= endB)
                        || checkPoint(productLimit, middleA, middleB));
    }

    static boolean checkPoint(long productLimit, int a, int b) {
        return (long) a * b < productLimit;
    }
}