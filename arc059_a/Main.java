import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static int solve(int[] a) {
        return IntStream.rangeClosed(Arrays.stream(a).min().getAsInt(), Arrays.stream(a).max().getAsInt())
                .map(x -> Arrays.stream(a).map(ai -> (ai - x) * (ai - x)).sum()).min().getAsInt();
    }
}