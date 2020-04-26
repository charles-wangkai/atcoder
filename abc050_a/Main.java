import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        char op = sc.next().charAt(0);
        int B = sc.nextInt();

        System.out.println(solve(A, op, B));

        sc.close();
    }

    static int solve(int A, char op, int B) {
        return (op == '+') ? (A + B) : (A - B);
    }
}