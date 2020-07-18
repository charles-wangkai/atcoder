import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        int[] sorted = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

        return Arrays.stream(A).mapToObj(x -> String.valueOf((x == sorted[0]) ? sorted[1] : sorted[0]))
                .collect(Collectors.joining("\n"));
    }
}