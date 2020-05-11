import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(A, B) ? "Possible" : "Impossible");

        sc.close();
    }

    static boolean solve(int A, int B) {
        return A % 3 == 0 || B % 3 == 0 || (A + B) % 3 == 0;
    }
}