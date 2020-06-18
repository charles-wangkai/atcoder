import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int N) {
        for (int i = 0; i * 4 <= N; ++i) {
            if ((N - i * 4) % 7 == 0) {
                return true;
            }
        }

        return false;
    }
}