import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int A = sc.nextInt();

        System.out.println(solve(X, A));

        sc.close();
    }

    static int solve(int X, int A) {
        return (X < A) ? 0 : 10;
    }
}