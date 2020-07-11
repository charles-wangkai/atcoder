import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();

        System.out.println(solve(A, P));

        sc.close();
    }

    static int solve(int A, int P) {
        return (3 * A + P) / 2;
    }
}