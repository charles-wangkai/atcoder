import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        System.out.println(solve(A, B) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int[] A, int[] B) {
        int[] sortedIndices = IntStream.range(0, A.length).boxed().sorted((i1, i2) -> Integer.compare(B[i1], B[i2]))
                .mapToInt(x -> x).toArray();

        int time = 0;
        for (int index : sortedIndices) {
            time += A[index];
            if (time > B[index]) {
                return false;
            }
        }

        return true;
    }
}