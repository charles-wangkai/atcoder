import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(A, B, K));

        sc.close();
    }

    static int solve(int A, int B, int K) {
        int count = 0;
        for (int i = Math.min(A, B);; --i) {
            if (A % i == 0 && B % i == 0) {
                ++count;
                if (count == K) {
                    return i;
                }
            }
        }
    }
}