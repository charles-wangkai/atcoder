import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int i = sc.nextInt();

        System.out.println(solve(N, i));

        sc.close();
    }

    static int solve(int N, int i) {
        return N + 1 - i;
    }
}