import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int N = sc.nextInt();

        System.out.println(solve(D, N));

        sc.close();
    }

    static int solve(int D, int N) {
        int result = (N == 100) ? 101 : N;
        for (int i = 0; i < D; ++i) {
            result *= 100;
        }

        return result;
    }
}