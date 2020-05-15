import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] l = new int[N];
        int[] r = new int[N];
        for (int i = 0; i < N; ++i) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        System.out.println(solve(l, r));

        sc.close();
    }

    static int solve(int[] l, int[] r) {
        return IntStream.range(0, l.length).map(i -> r[i] - l[i] + 1).sum();
    }
}