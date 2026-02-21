import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int[] c = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; ++i) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        System.out.println(solve(a, b, c, d));

        sc.close();
    }

    static int solve(int[] a, int[] b, int[] c, int[] d) {
        int N = a.length;

        @SuppressWarnings("unchecked")
        List<Integer>[] leftAdjLists = new List[N];
        for (int i = 0; i < leftAdjLists.length; ++i) {
            leftAdjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (a[i] < c[j] && b[i] < d[j]) {
                    leftAdjLists[i].add(j);
                }
            }
        }

        int matchCount = 0;
        int[] leftMatches = IntStream.range(0, N).map(i -> -1).toArray();
        int[] rightMatches = IntStream.range(0, N).map(i -> -1).toArray();
        for (int i = 0; i < leftMatches.length; ++i) {
            if (leftMatches[i] == -1 && search(leftAdjLists, leftMatches, rightMatches, new boolean[N], i)) {
                ++matchCount;
            }
        }

        return matchCount;
    }

    static boolean search(List<Integer>[] leftAdjLists, int[] leftMatches, int[] rightMatches, boolean[] rightVisited,
            int leftIndex) {
        for (int rightIndex : leftAdjLists[leftIndex]) {
            if (!rightVisited[rightIndex]) {
                rightVisited[rightIndex] = true;

                if (rightMatches[rightIndex] == -1
                        || search(leftAdjLists, leftMatches, rightMatches, rightVisited, rightMatches[rightIndex])) {
                    leftMatches[leftIndex] = rightIndex;
                    rightMatches[rightIndex] = leftIndex;

                    return true;
                }
            }
        }

        return false;
    }
}