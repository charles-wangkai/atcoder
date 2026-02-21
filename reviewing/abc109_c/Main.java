import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < x.length; ++i) {
            x[i] = sc.nextInt();
        }

        System.out.println(solve(x, X));

        sc.close();
    }

    static int solve(int[] x, int X) {
        return Arrays.stream(x).map(xi -> Math.abs(xi - X)).reduce(Main::gcd).getAsInt();
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}