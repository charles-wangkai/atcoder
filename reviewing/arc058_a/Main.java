import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] D = new int[K];
        for (int i = 0; i < D.length; ++i) {
            D[i] = sc.nextInt();
        }

        System.out.println(solve(N, D));

        sc.close();
    }

    static int solve(int N, int[] D) {
        Set<Integer> setD = Arrays.stream(D).boxed().collect(Collectors.toSet());

        for (int i = N;; ++i) {
            if (String.valueOf(i).chars().allMatch(ch -> !setD.contains(ch - '0'))) {
                return i;
            }
        }
    }
}