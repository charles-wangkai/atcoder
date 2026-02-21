import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

    static String solve(int[] a) {
        Set<Integer> colors = new HashSet<>();
        int freeCount = 0;
        for (int ai : a) {
            if (ai <= 3199) {
                colors.add(ai / 400);
            } else {
                ++freeCount;
            }
        }

        int minColorNum = Math.max(1, colors.size());
        int maxColorNum = colors.size() + freeCount;

        return String.format("%d %d", minColorNum, maxColorNum);
    }
}