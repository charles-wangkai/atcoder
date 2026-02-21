import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        return (int) IntStream.rangeClosed(1, N)
                .filter(x -> x % 2 != 0 && IntStream.rangeClosed(1, x).filter(d -> x % d == 0).count() == 8).count();
    }
}