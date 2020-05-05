import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(solve(A, B, C) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int A, int B, int C) {
        return C >= A && C <= B;
    }
}