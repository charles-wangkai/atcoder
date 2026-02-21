import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();

        System.out.println(solve(N, A) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int N, int A) {
        return N % 500 <= A;
    }
}