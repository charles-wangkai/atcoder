import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        System.out.println(solve(x, y, K));

        sc.close();
    }

    static long solve(int[] x, int[] y, int K) {
        long result = Long.MAX_VALUE;
        for (int minX : x) {
            for (int maxX : x) {
                for (int minY : y) {
                    for (int maxY : y) {
                        int interiorCount = 0;
                        for (int i = 0; i < x.length; ++i) {
                            if (x[i] >= minX && x[i] <= maxX && y[i] >= minY && y[i] <= maxY) {
                                ++interiorCount;
                            }
                        }

                        if (interiorCount >= K) {
                            result = Math.min(result, (long) (maxX - minX) * (maxY - minY));
                        }
                    }
                }
            }
        }

        return result;
    }
}