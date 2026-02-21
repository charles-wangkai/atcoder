import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        System.out.println(solve(X));

        sc.close();
    }

    static int solve(int X) {
        return X / 500 * 1000 + X % 500 / 5 * 5;
    }
}