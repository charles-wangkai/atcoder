import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();

        System.out.println(solve(A, B, C, X));

        sc.close();
    }

    static int solve(int A, int B, int C, int X) {
        int result = 0;
        for (int i = 0; i <= A; ++i) {
            for (int j = 0; j <= B; ++j) {
                for (int k = 0; k <= C; ++k) {
                    if (i * 500 + j * 100 + k * 50 == X) {
                        ++result;
                    }
                }
            }
        }

        return result;
    }
}