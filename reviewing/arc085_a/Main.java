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
        return (M * 1900 + (N - M) * 100) * (1 << M);
    }
}