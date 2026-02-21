import java.util.Arrays;
import java.util.Collections;
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
        int[] sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

        int aliceScore = IntStream.range(0, sorted.length).filter(i -> i % 2 == 0).map(i -> sorted[i]).sum();
        int bobScore = Arrays.stream(sorted).sum() - aliceScore;

        return aliceScore - bobScore;
    }
}