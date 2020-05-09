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

    static String solve(int X, int A, int B) {
        if (B <= A) {
            return "delicious";
        } else if (B <= A + X) {
            return "safe";
        } else {
            return "dangerous";
        }
    }
}