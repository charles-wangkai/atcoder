import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt();
        }

        System.out.println(solve(p));

        sc.close();
    }

    static int solve(int[] p) {
        return (int) IntStream.range(1, p.length - 1).filter(i -> p[i - 1] < p[i] == p[i] < p[i + 1]).count();
    }
}