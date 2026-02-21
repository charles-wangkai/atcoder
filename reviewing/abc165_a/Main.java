import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(K, A, B) ? "OK" : "NG");

        sc.close();
    }

    static boolean solve(int K, int A, int B) {
        return IntStream.rangeClosed(A, B).anyMatch(x -> x % K == 0);
    }
}