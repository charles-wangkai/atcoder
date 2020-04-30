import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        System.out.println(solve(X));

        sc.close();
    }

    static int solve(int X) {
        int sum = 0;
        for (int i = 1;; ++i) {
            sum += i;
            if (sum >= X) {
                return i;
            }
        }
    }
}