import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; ++i) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        System.out.println(solve(w, v, W));

        sc.close();
    }

    static int solve(int[] w, int[] v, int W) {
        int base = w[0];

        @SuppressWarnings("unchecked")
        List<Integer>[] values = new List[4];
        for (int i = 0; i < values.length; ++i) {
            values[i] = new ArrayList<>();
        }

        for (int i = 0; i < w.length; ++i) {
            values[w[i] - base].add(v[i]);
        }

        for (int i = 0; i < values.length; ++i) {
            Collections.sort(values[i], Collections.reverseOrder());
        }

        return search(values, W, base, 0, 0, 0);
    }

    static int search(List<Integer>[] values, int restWeight, int base, int rowIndex, int colIndex, int totalValue) {
        if (rowIndex == values.length) {
            return totalValue;
        }

        int result = 0;
        if (colIndex != values[rowIndex].size() && restWeight >= base + rowIndex) {
            result = Math.max(result, search(values, restWeight - (base + rowIndex), base, rowIndex, colIndex + 1,
                    totalValue + values[rowIndex].get(colIndex)));
        }

        result = Math.max(result, search(values, restWeight, base, rowIndex + 1, 0, totalValue));

        return result;
    }
}