import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int W = sc.nextInt();

        System.out.println(solve(S, W));

        sc.close();
    }

    static String solve(int S, int W) {
        return (S > W) ? "safe" : "unsafe";
    }
}