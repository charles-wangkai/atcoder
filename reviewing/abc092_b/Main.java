import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int X = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A, D, X));

        sc.close();
    }

    static int solve(int[] A, int D, int X) {
        int result = X;
        for (int i = 1; i <= D; ++i) {
            for (int a : A) {
                if ((i - 1) % a == 0) {
                    ++result;
                }
            }
        }

        return result;
    }
}