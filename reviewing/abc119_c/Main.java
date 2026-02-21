import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] l = new int[N];
        for (int i = 0; i < l.length; ++i) {
            l[i] = sc.nextInt();
        }

        System.out.println(solve(l, A, B, C));

        sc.close();
    }

    static int solve(int[] l, int A, int B, int C) {
        int[] targets = { A, B, C };

        int result = Integer.MAX_VALUE;
        for (int code = 0; code < (1 << (2 * l.length)) - 1; ++code) {
            int[] counts = new int[3];
            int[] sums = new int[3];
            int[] groups = decode(l.length, code);
            for (int i = 0; i < l.length; ++i) {
                if (groups[i] != 3) {
                    ++counts[groups[i]];
                    sums[groups[i]] += l[i];
                }
            }

            if (Arrays.stream(counts).allMatch(count -> count != 0)) {
                result = Math.min(result,
                        IntStream.range(0, 3).map(i -> (counts[i] - 1) * 10 + Math.abs(sums[i] - targets[i])).sum());
            }
        }

        return result;
    }

    static int[] decode(int size, int code) {
        int[] groups = new int[size];
        for (int i = 0; i < groups.length; ++i) {
            groups[i] = code % 4;
            code /= 4;
        }

        return groups;
    }
}