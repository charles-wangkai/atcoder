import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] X = new int[N];
        for (int i = 0; i < X.length; ++i) {
            X[i] = sc.nextInt();
        }

        System.out.println(solve(X));

        sc.close();
    }

    static String solve(int[] X) {
        int[] sorted = Arrays.stream(X).boxed().sorted().mapToInt(x -> x).toArray();

        int leftMedian = sorted[sorted.length / 2 - 1];
        int rightMedian = sorted[sorted.length / 2];

        return Arrays.stream(X).mapToObj(x -> String.valueOf((x <= leftMedian) ? rightMedian : leftMedian))
                .collect(Collectors.joining("\n"));
    }
}