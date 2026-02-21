import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < x.length; ++i) {
            x[i] = sc.nextInt();
        }
        int[] y = new int[M];
        for (int i = 0; i < y.length; ++i) {
            y[i] = sc.nextInt();
        }

        System.out.println(solve(x, y, X, Y) ? "War" : "No War");

        sc.close();
    }

    static boolean solve(int[] x, int[] y, int X, int Y) {
        return IntStream.concat(IntStream.of(X), Arrays.stream(x)).max().getAsInt() >= IntStream
                .concat(IntStream.of(Y), Arrays.stream(y)).min().getAsInt();
    }
}