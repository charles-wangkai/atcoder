import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

    static int solve(int[] A) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 0; i < 2; ++i) {
            for (int j = 1; j * j <= A[i]; ++j) {
                if (A[i] % j == 0) {
                    divisors.add(j);
                    divisors.add(A[i] / j);
                }
            }
        }

        return divisors.stream()
                .filter(divisor -> Arrays.stream(A).filter(x -> x % divisor == 0).count() >= A.length - 1)
                .mapToInt(x -> x).max().getAsInt();
    }
}