import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        System.out.println(solve(M));

        sc.close();
    }

    static int solve(int M) {
        return 48 - M;
    }
}