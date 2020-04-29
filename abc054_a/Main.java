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
        if (A == 1) {
            A += 13;
        }
        if (B == 1) {
            B += 13;
        }

        if (A < B) {
            return "Bob";
        } else if (A > B) {
            return "Alice";
        } else {
            return "Draw";
        }
    }
}