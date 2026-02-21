import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();

        System.out.println(solve(X, Y));

        sc.close();
    }

    static int solve(long X, long Y) {
        int result = 0;
        for (long i = X; i <= Y; i *= 2) {
            ++result;
        }

        return result;
    }
}