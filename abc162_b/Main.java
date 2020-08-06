import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static long solve(int N) {
        return IntStream.rangeClosed(1, N).map(i -> (i % 3 != 0 && i % 5 != 0) ? i : 0).asLongStream().sum();
    }
}