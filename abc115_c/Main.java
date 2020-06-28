import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < h.length; ++i) {
            h[i] = sc.nextInt();
        }

        System.out.println(solve(h, K));

        sc.close();
    }

    static int solve(int[] h, int K) {
        h = Arrays.stream(h).boxed().sorted().mapToInt(x -> x).toArray();

        int[] h_ = h;
        return IntStream.rangeClosed(0, h.length - K).map(i -> h_[i + K - 1] - h_[i]).min().getAsInt();
    }
}