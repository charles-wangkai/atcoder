import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] large = new String[N];
        int[] m = new int[N];
        String[] small = new String[N];
        for (int i = 0; i < N; ++i) {
            large[i] = sc.next();
            m[i] = sc.nextInt();
            small[i] = sc.next();
        }

        System.out.println(solve(large, m, small));

        sc.close();
    }

    static String solve(String[] large, int[] m, String[] small) {
        List<String> units = Stream.concat(Arrays.stream(large), Arrays.stream(small)).distinct()
                .collect(Collectors.toList());
        Map<String, Integer> unitToIndex = IntStream.range(0, units.size()).boxed()
                .collect(Collectors.toMap(i -> units.get(i), Function.identity()));

        int unitNum = units.size();
        boolean[][] reaches = new boolean[unitNum][unitNum];
        double[][] conversions = new double[unitNum][unitNum];
        for (int i = 0; i < unitNum; ++i) {
            reaches[i][i] = true;
            conversions[i][i] = 1;
        }
        for (int i = 0; i < large.length; ++i) {
            int index1 = unitToIndex.get(large[i]);
            int index2 = unitToIndex.get(small[i]);

            reaches[index1][index2] = true;
            conversions[index1][index2] = m[i];

            reaches[index2][index1] = true;
            conversions[index2][index1] = 1.0 / m[i];
        }

        for (int k = 0; k < unitNum; ++k) {
            for (int i = 0; i < unitNum; ++i) {
                for (int j = 0; j < unitNum; ++j) {
                    if (!reaches[i][j] && reaches[i][k] && reaches[k][j]) {
                        reaches[i][j] = true;
                        conversions[i][j] = conversions[i][k] * conversions[k][j];
                    }
                }
            }
        }

        String result = null;
        double maxConversion = -Double.MAX_VALUE;
        for (int i = 0; i < unitNum; ++i) {
            for (int j = 0; j < unitNum; ++j) {
                if (conversions[i][j] > maxConversion) {
                    maxConversion = conversions[i][j];
                    result = String.format("1%s=%d%s", units.get(i), Math.round(conversions[i][j]), units.get(j));
                }
            }
        }

        return result;
    }
}