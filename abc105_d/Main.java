import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A, M));

        sc.close();
    }

    static long solve(int[] A, int M) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);

        long result = 0;
        int sum = 0;
        for (int Ai : A) {
            sum = (sum + Ai) % M;
            result += sumToCount.getOrDefault(sum, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}