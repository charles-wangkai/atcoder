import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(A, B));

        sc.close();
    }

    static String solve(int A, int B) {
        return (A + B >= 10) ? "error" : String.valueOf(A + B);
    }
}