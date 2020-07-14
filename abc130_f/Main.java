import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        char[] d = new char[N];
        for (int i = 0; i < N; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            d[i] = sc.next().charAt(0);
        }

        System.out.println(solve(x, y, d));

        sc.close();
    }

    static double solve(int[] x, int[] y, char[] d) {
        int xStillMin = Integer.MAX_VALUE;
        int xStillMax = Integer.MIN_VALUE;
        int xIncrMin = Integer.MAX_VALUE;
        int xIncrMax = Integer.MIN_VALUE;
        int xDecrMin = Integer.MAX_VALUE;
        int xDecrMax = Integer.MIN_VALUE;

        int yStillMin = Integer.MAX_VALUE;
        int yStillMax = Integer.MIN_VALUE;
        int yIncrMin = Integer.MAX_VALUE;
        int yIncrMax = Integer.MIN_VALUE;
        int yDecrMin = Integer.MAX_VALUE;
        int yDecrMax = Integer.MIN_VALUE;

        for (int i = 0; i < x.length; ++i) {
            x[i] *= 2;
            y[i] *= 2;

            if (d[i] == 'R') {
                xIncrMin = Math.min(xIncrMin, x[i]);
                xIncrMax = Math.max(xIncrMax, x[i]);

                yStillMin = Math.min(yStillMin, y[i]);
                yStillMax = Math.max(yStillMax, y[i]);
            } else if (d[i] == 'L') {
                xDecrMin = Math.min(xDecrMin, x[i]);
                xDecrMax = Math.max(xDecrMax, x[i]);

                yStillMin = Math.min(yStillMin, y[i]);
                yStillMax = Math.max(yStillMax, y[i]);
            } else if (d[i] == 'U') {
                xStillMin = Math.min(xStillMin, x[i]);
                xStillMax = Math.max(xStillMax, x[i]);

                yIncrMin = Math.min(yIncrMin, y[i]);
                yIncrMax = Math.max(yIncrMax, y[i]);
            } else {
                xStillMin = Math.min(xStillMin, x[i]);
                xStillMax = Math.max(xStillMax, x[i]);

                yDecrMin = Math.min(yDecrMin, y[i]);
                yDecrMax = Math.max(yDecrMax, y[i]);
            }
        }

        long minArea = Long.MAX_VALUE;
        int prevXDiff = Integer.MAX_VALUE;
        int prevYDiff = Integer.MAX_VALUE;
        while (true) {
            int xMin = Math.min(Math.min(xIncrMin, xDecrMin), xStillMin);
            int xMax = Math.max(Math.max(xIncrMax, xDecrMax), xStillMax);
            int xDiff = xMax - xMin;

            int yMin = Math.min(Math.min(yIncrMin, yDecrMin), yStillMin);
            int yMax = Math.max(Math.max(yIncrMax, yDecrMax), yStillMax);
            int yDiff = yMax - yMin;

            if (xDiff >= prevXDiff && yDiff >= prevYDiff) {
                break;
            }

            minArea = Math.min(minArea, (long) xDiff * yDiff);

            prevXDiff = xDiff;
            prevYDiff = yDiff;

            if (xIncrMin != Integer.MAX_VALUE) {
                ++xIncrMin;
                ++xIncrMax;
            }
            if (xDecrMin != Integer.MAX_VALUE) {
                --xDecrMin;
                --xDecrMax;
            }

            if (yIncrMin != Integer.MAX_VALUE) {
                ++yIncrMin;
                ++yIncrMax;
            }
            if (yDecrMin != Integer.MAX_VALUE) {
                --yDecrMin;
                --yDecrMax;
            }
        }

        return minArea / 4.0;
    }
}