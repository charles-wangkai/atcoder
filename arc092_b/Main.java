import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = readArray(br, N);
        int[] b = readArray(br, N);

        System.out.println(solve(a, b));

        br.close();
    }

    static int[] readArray(BufferedReader br, int size) throws Throwable {
        int[] result = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        return result;
    }

    static int solve(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i <= 28; ++i) {
            int T = 1 << i;
            if (isXORBitOne(mod2T(a, T), mod2T(b, T), T)) {
                result += T;
            }
        }

        return result;
    }

    static int[] mod2T(int[] values, int T) {
        int[] result = new int[values.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = values[i] % (2 * T);
        }

        return result;
    }

    static boolean isXORBitOne(int[] a, int[] b, int T) {
        Arrays.sort(b);

        long oneCount = 0;
        for (int ai : a) {
            oneCount += findNum(b, T - ai, 2 * T - 1 - ai) + findNum(b, 3 * T - ai, 4 * T - 1 - ai);
        }

        return oneCount % 2 != 0;
    }

    static int findNum(int[] b, int minTarget, int maxTarget) {
        return findMaxIndex(b, maxTarget) - findMinIndex(b, minTarget) + 1;
    }

    static int findMaxIndex(int[] b, int maxTarget) {
        int result = -1;
        int lower = 0;
        int upper = b.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (b[middle] <= maxTarget) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }

    static int findMinIndex(int[] b, int minTarget) {
        int result = b.length;
        int lower = 0;
        int upper = b.length - 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (b[middle] >= minTarget) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }

        return result;
    }
}