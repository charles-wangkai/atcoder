import java.util.Scanner;

public class Main {
    static final int[][] GROUPS = { { 1, 3, 5, 7, 8, 10, 12 }, { 4, 6, 9, 11 }, { 2 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(solve(x, y) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int x, int y) {
        return findGroup(x) == findGroup(y);
    }

    static int findGroup(int n) {
        for (int i = 0;; ++i) {
            for (int v : GROUPS[i]) {
                if (n == v) {
                    return i;
                }
            }
        }
    }
}