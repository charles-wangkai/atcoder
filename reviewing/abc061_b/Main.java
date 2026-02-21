import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(N, a, b));

        sc.close();
    }

    static String solve(int N, int[] a, int[] b) {
        int[] counts = new int[N];
        for (int i = 0; i < a.length; ++i) {
            ++counts[a[i]];
            ++counts[b[i]];
        }

        return Arrays.stream(counts).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}