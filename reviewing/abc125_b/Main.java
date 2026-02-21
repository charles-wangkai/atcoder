import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] V = new int[N];
        for (int i = 0; i < V.length; ++i) {
            V[i] = sc.nextInt();
        }
        int[] C = new int[N];
        for (int i = 0; i < C.length; ++i) {
            C[i] = sc.nextInt();
        }

        System.out.println(solve(V, C));

        sc.close();
    }

    static int solve(int[] V, int[] C) {
        return IntStream.range(0, V.length).map(i -> Math.max(0, V[i] - C[i])).sum();
    }
}