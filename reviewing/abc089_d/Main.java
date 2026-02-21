import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int D = sc.nextInt();
        int[][] A = new int[H][W];
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                A[r][c] = sc.nextInt() - 1;
            }
        }
        int Q = sc.nextInt();
        int[] L = new int[Q];
        int[] R = new int[Q];
        for (int i = 0; i < Q; ++i) {
            L[i] = sc.nextInt() - 1;
            R[i] = sc.nextInt() - 1;
        }

        System.out.println(solve(A, D, L, R));

        sc.close();
    }

    static String solve(int[][] A, int D, int[] L, int[] R) {
        int H = A.length;
        int W = A[0].length;

        Point[] points = new Point[H * W];
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                points[A[r][c]] = new Point(r, c);
            }
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] prefixSumLists = new List[D];
        for (int i = 0; i < prefixSumLists.length; ++i) {
            prefixSumLists[i] = new ArrayList<>();
            int prefixSum = 0;
            for (int j = i; j < points.length; j += D) {
                prefixSum += computeDistance(points, j - D, j);
                prefixSumLists[i].add(prefixSum);
            }
        }

        return IntStream.range(0, L.length).mapToObj(i -> {
            int m = L[i] % D;
            int indexL = L[i] / D;
            int indexR = R[i] / D;

            return String.valueOf(prefixSumLists[m].get(indexR) - prefixSumLists[m].get(indexL));
        }).collect(Collectors.joining("\n"));
    }

    static int computeDistance(Point[] points, int index1, int index2) {
        if (index1 < 0) {
            return 0;
        }

        return Math.abs(points[index1].r - points[index2].r) + Math.abs(points[index1].c - points[index2].c);
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}