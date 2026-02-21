import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static String solve(int[] a) {
        int N = Arrays.stream(a).max().getAsInt();
        int r = Arrays.stream(a).filter(ai -> ai != N).boxed()
                .max((a1, a2) -> Integer.compare(Math.min(a1, N - a1), Math.min(a2, N - a2))).get();

        return String.format("%d %d", N, r);
    }
}