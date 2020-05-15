import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(solve(X, t));

        sc.close();
    }

    static int solve(int X, int t) {
        return Math.max(0, X - t);
    }
}