import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static String solve(int N) {
        return String.format("ABC%d", N);
    }
}