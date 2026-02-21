import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(a, b, c, d, e, k));

        sc.close();
    }

    static String solve(int a, int b, int c, int d, int e, int k) {
        return (e - a <= k) ? "Yay!" : ":(";
    }
}