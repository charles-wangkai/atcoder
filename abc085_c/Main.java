import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(solve(N, Y));

        sc.close();
    }

    static String solve(int N, int Y) {
        for (int x = 0; x <= N; ++x) {
            for (int y = 0; x + y <= N; ++y) {
                int z = N - x - y;

                if (x * 10000 + y * 5000 + z * 1000 == Y) {
                    return String.format("%d %d %d", x, y, z);
                }
            }
        }

        return "-1 -1 -1";
    }
}