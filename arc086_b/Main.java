import java.util.ArrayList;
import java.util.List;
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

    static String solve(int[] a) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }

        List<String> operations = new ArrayList<>();
        if (a[minIndex] + a[maxIndex] >= 0) {
            for (int i = 0; i < a.length; ++i) {
                operations.add(String.format("%d %d", maxIndex + 1, i + 1));
            }

            for (int i = 0; i < a.length - 1; ++i) {
                operations.add(String.format("%d %d", i + 1, i + 2));
            }
        } else {
            for (int i = 0; i < a.length; ++i) {
                operations.add(String.format("%d %d", minIndex + 1, i + 1));
            }

            for (int i = a.length - 1; i >= 1; --i) {
                operations.add(String.format("%d %d", i + 1, i));
            }
        }

        return String.format("%d\n%s", operations.size(), String.join("\n", operations));
    }
}