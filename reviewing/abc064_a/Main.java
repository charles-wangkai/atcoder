import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solve(r, g, b) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(int r, int g, int b) {
        return (g * 10 + b) % 4 == 0;
    }
}