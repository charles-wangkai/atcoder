import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static long solve(int[] A) {
        long absSum = Arrays.stream(A).map(Math::abs).asLongStream().sum();

        if (Arrays.stream(A).filter(x -> x < 0).count() % 2 == 0) {
            return absSum;
        }

        return absSum - Arrays.stream(A).map(Math::abs).min().getAsInt() * 2;
    }
}