import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static long solve(int N) {
        long prev = 2;
        long curr = 1;
        for (int i = 0; i < N - 1; ++i) {
            long next = prev + curr;

            prev = curr;
            curr = next;
        }

        return curr;
    }
}