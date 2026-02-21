import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[] r = new int[R];
        for (int i = 0; i < r.length; ++i) {
            r[i] = sc.nextInt() - 1;
        }
        int[] A = new int[M];
        int[] B = new int[M];
        int[] C = new int[M];
        for (int i = 0; i < M; ++i) {
            A[i] = sc.nextInt() - 1;
            B[i] = sc.nextInt() - 1;
            C[i] = sc.nextInt();
        }

        System.out.println(solve(N, A, B, C, r));

        sc.close();
    }

    static int solve(int N, int[] A, int[] B, int[] C, int[] r) {
        int[][] distances = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < A.length; ++i) {
            distances[A[i]][B[i]] = C[i];
            distances[B[i]][A[i]] = C[i];
        }

        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        return search(distances, r, 0);
    }

    static int search(int[][] distances, int[] r, int index) {
        if (index == r.length) {
            return IntStream.range(0, r.length - 1).map(i -> distances[r[i]][r[i + 1]]).sum();
        }

        int result = Integer.MAX_VALUE;
        for (int i = index; i < r.length; ++i) {
            swap(r, i, index);
            result = Math.min(result, search(distances, r, index + 1));
            swap(r, i, index);
        }

        return result;
    }

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}