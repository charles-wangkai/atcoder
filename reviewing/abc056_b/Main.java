import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solve(W, a, b));

        sc.close();
    }

    static int solve(int W, int a, int b) {
        if (b > a + W) {
            return b - (a + W);
        } else if (a > b + W) {
            return a - (b + W);
        } else {
            return 0;
        }
    }
}