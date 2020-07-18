import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N + 1];
        for (int i = 1; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static String solve(int[] a) {
        boolean[] balls = new boolean[a.length];
        for (int i = a.length - 1; i >= 1; --i) {
            balls[i] = a[i] == 1;
            for (int j = i + i; j < balls.length; j += i) {
                if (balls[j]) {
                    balls[i] = !balls[i];
                }
            }
        }

        int[] b = IntStream.range(1, balls.length).filter(i -> balls[i]).toArray();

        return String.format("%d\n%s", b.length,
                Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
    }
}