import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int X = sc.nextInt();

        System.out.println(solve(T, X));

        sc.close();
    }

    static double solve(int T, int X) {
        return (double) T / X;
    }
}