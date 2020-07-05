import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int Q = sc.nextInt();
        String S = sc.next();
        int[] l = new int[Q];
        int[] r = new int[Q];
        for (int i = 0; i < Q; ++i) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        System.out.println(solve(l, r, S));

        sc.close();
    }

    static String solve(int[] l, int[] r, String S) {
        int[] prefixCounts = new int[S.length()];
        int prefixCount = 0;
        for (int i = 1; i < prefixCounts.length; ++i) {
            if (S.charAt(i - 1) == 'A' && S.charAt(i) == 'C') {
                ++prefixCount;
            }

            prefixCounts[i] = prefixCount;
        }

        return IntStream.range(0, l.length)
                .mapToObj(i -> String.valueOf(prefixCounts[r[i] - 1] - prefixCounts[l[i] - 1]))
                .collect(Collectors.joining("\n"));
    }
}