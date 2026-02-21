import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(solve(X, Y));

        sc.close();
    }

    static int solve(int X, int Y) {
        return X + Y / 2;
    }
}