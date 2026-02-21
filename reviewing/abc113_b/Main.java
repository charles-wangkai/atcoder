import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int A = sc.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < H.length; ++i) {
            H[i] = sc.nextInt();
        }

        System.out.println(solve(H, T, A));

        sc.close();
    }

    static int solve(int[] H, int T, int A) {
        return IntStream.range(0, H.length).boxed().min((i1, i2) -> Integer
                .compare(Math.abs(1000 * T - 6 * H[i1] - 1000 * A), Math.abs(1000 * T - 6 * H[i2] - 1000 * A))).get()
                + 1;
    }
}