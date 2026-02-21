import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(X, A, B));

        sc.close();
    }

    static int solve(int X, int A, int B) {
        return (X - A) % B;
    }
}