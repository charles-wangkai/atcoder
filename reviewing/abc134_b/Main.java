import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(solve(N, D));

        sc.close();
    }

    static int solve(int N, int D) {
        return (N + D * 2) / (D * 2 + 1);
    }
}