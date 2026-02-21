import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < h.length; ++i) {
            h[i] = sc.nextInt();
        }

        System.out.println(solve(h));

        sc.close();
    }

    static int solve(int[] h) {
        return IntStream.range(0, h.length).map(i -> (i == 0) ? h[i] : Math.max(0, h[i] - h[i - 1])).sum();
    }
}