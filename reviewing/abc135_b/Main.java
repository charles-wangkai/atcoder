import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt();
        }

        System.out.println(solve(p) ? "YES" : "NO");

        sc.close();
    }

    static boolean solve(int[] p) {
        return IntStream.range(0, p.length).filter(i -> i + 1 != p[i]).count() <= 2;
    }
}