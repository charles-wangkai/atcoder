import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static String solve(int[] A) {
        int[] spots = new int[A.length + 2];
        for (int i = 1; i < spots.length - 1; ++i) {
            spots[i] = A[i - 1];
        }

        int total = IntStream.range(0, spots.length - 1).map(i -> Math.abs(spots[i + 1] - spots[i])).sum();

        return IntStream.range(1, spots.length - 1)
                .mapToObj(i -> String.valueOf(total - Math.abs(spots[i] - spots[i - 1])
                        - Math.abs(spots[i + 1] - spots[i]) + Math.abs(spots[i + 1] - spots[i - 1])))
                .collect(Collectors.joining("\n"));
    }
}