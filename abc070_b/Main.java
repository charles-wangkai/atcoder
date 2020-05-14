import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(solve(A, B, C, D));

        sc.close();
    }

    static int solve(int A, int B, int C, int D) {
        return Math.max(0, Math.min(B, D) - Math.max(A, C));
    }
}