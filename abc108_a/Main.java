import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        System.out.println(solve(K));

        sc.close();
    }

    static int solve(int K) {
        int even = K / 2;
        int odd = K - even;

        return even * odd;
    }
}