import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();

        System.out.println(solve(N, A));

        sc.close();
    }

    static int solve(int N, int A) {
        return N * N - A;
    }
}