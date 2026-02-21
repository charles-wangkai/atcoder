import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(1);
        for (int i = 6; i <= N; i *= 6) {
            amounts.add(i);
        }
        for (int i = 9; i <= N; i *= 9) {
            amounts.add(i);
        }

        int[] minOperationNums = new int[N + 1];
        Arrays.fill(minOperationNums, Integer.MAX_VALUE);
        minOperationNums[0] = 0;

        for (int i = 1; i < minOperationNums.length; ++i) {
            for (int amount : amounts) {
                if (i >= amount) {
                    minOperationNums[i] = Math.min(minOperationNums[i], minOperationNums[i - amount] + 1);
                }
            }
        }

        return minOperationNums[N];
    }
}