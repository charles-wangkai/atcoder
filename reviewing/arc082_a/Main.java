import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    static int solve(int[] a) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int ai : a) {
            for (int value : new int[] { ai - 1, ai, ai + 1 }) {
                valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
            }
        }

        return valueToCount.values().stream().mapToInt(x -> x).max().getAsInt();
    }
}