import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();

        System.out.println(solve(X, Y, Z));

        sc.close();
    }

    static String solve(int X, int Y, int Z) {
        return String.format("%d %d %d", Z, X, Y);
    }
}