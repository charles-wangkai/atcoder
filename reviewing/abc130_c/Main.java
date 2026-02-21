import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(solve(W, H, x, y));

        sc.close();
    }

    static String solve(int W, int H, int x, int y) {
        return String.format("%f %d", W / 2.0 * H, (x * 2 == W && y * 2 == H) ? 1 : 0);
    }
}