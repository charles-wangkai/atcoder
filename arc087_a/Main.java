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
        for (int value : a) {
            valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
        }

        return valueToCount.keySet().stream()
                .mapToInt(value -> valueToCount.get(value) - ((valueToCount.get(value) >= value) ? value : 0)).sum();
    }
}