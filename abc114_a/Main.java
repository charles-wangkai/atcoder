import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        System.out.println(solve(X) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(int X) {
        return X == 3 || X == 5 || X == 7;
    }
}