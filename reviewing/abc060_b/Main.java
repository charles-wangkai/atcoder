import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(solve(A, B, C) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(int A, int B, int C) {
        boolean[] seen = new boolean[B];
        int index = 0;
        while (true) {
            index = (index + A) % B;
            if (index == C) {
                return true;
            }
            if (seen[index]) {
                return false;
            }

            seen[index] = true;
        }
    }
}