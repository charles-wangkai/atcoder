import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        int C = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(solve(A, B, C, D));

        sc.close();
    }

    static long solve(long A, long B, int C, int D) {
        return B - A + 1 - computeMultipleNum(A, B, C) - computeMultipleNum(A, B, D)
                + computeMultipleNum(A, B, lcm(C, D));
    }

    static long lcm(int x, int y) {
        return (long) x * y / gcd(x, y);
    }

    static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    static long computeMultipleNum(long A, long B, long factor) {
        long min = (A + factor - 1) / factor;
        long max = B / factor;

        return max - min + 1;
    }
}