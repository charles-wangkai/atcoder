import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(solve(N, M));

        sc.close();
    }

    static int solve(int N, int M) {
        int result = -1;
        for (int i = 1; i * i <= M; ++i) {
            if (M % i == 0) {
                if (i >= N) {
                    result = Math.max(result, M / i);
                }
                if (M / i >= N) {
                    result = Math.max(result, i);
                }
            }
        }

        return result;
    }
}